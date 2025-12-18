#!/usr/bin/env python3
"""
Download all JEPs from OpenJDK and convert them to Markdown format.
Reads URLs from jep_urls.txt and generates .md files in the jeps/ directory.
"""

import os
import sys
import time
import urllib.request
import urllib.error
from html.parser import HTMLParser
from concurrent.futures import ThreadPoolExecutor, as_completed
import re


class JEPHTMLToMarkdown(HTMLParser):
    """HTML parser that converts JEP content to Markdown format"""

    def __init__(self):
        super().__init__()
        self.markdown = []
        self.in_main = False
        self.in_title = False
        self.in_table = False
        self.in_pre = False
        self.in_heading = False
        self.heading_level = 0
        self.current_text = []
        self.list_level = 0
        self.in_list_item = False

    def handle_starttag(self, tag, attrs):
        attrs_dict = dict(attrs)

        if tag == 'div' and attrs_dict.get('id') == 'main':
            self.in_main = True
        elif self.in_main:
            if tag == 'h1':
                self.in_title = True
                self.in_heading = True
                self.heading_level = 1
            elif tag in ['h2', 'h3', 'h4', 'h5', 'h6']:
                level = int(tag[1])
                self.in_heading = True
                self.heading_level = level
                self.markdown.append('\n' + '#' * level + ' ')
            elif tag == 'table':
                self.in_table = True
                self.markdown.append('\n')
            elif tag == 'tr':
                self.markdown.append('| ')
            elif tag == 'td' or tag == 'th':
                pass
            elif tag == 'pre':
                self.in_pre = True
                self.markdown.append('\n```\n')
            elif tag == 'code' and not self.in_pre:
                self.markdown.append('`')
            elif tag == 'p':
                self.markdown.append('\n')
            elif tag == 'br':
                self.markdown.append('\n')
            elif tag == 'a':
                href = attrs_dict.get('href', '')
                if href:
                    self.current_text.append(('[', href))
            elif tag == 'ul':
                self.list_level += 1
                self.markdown.append('\n')
            elif tag == 'ol':
                self.list_level += 1
                self.markdown.append('\n')
            elif tag == 'li':
                self.in_list_item = True
                indent = '  ' * (self.list_level - 1)
                self.markdown.append(f'{indent}- ')
            elif tag == 'strong' or tag == 'b':
                self.markdown.append('**')
            elif tag == 'em' or tag == 'i':
                self.markdown.append('*')

    def handle_endtag(self, tag):
        if tag == 'div' and self.in_main:
            self.in_main = False
        elif self.in_main:
            if tag == 'h1' and self.in_title:
                self.in_title = False
                self.in_heading = False
                self.markdown.append('\n' + '=' * 70 + '\n')
            elif tag in ['h2', 'h3', 'h4', 'h5', 'h6']:
                self.in_heading = False
                self.markdown.append('\n')
            elif tag == 'table':
                self.in_table = False
                self.markdown.append('\n')
            elif tag == 'tr':
                self.markdown.append('\n')
            elif tag == 'td' or tag == 'th':
                self.markdown.append(' | ')
            elif tag == 'pre':
                self.in_pre = False
                self.markdown.append('\n```\n')
            elif tag == 'code' and not self.in_pre:
                self.markdown.append('`')
            elif tag == 'a':
                if self.current_text and isinstance(self.current_text[-1], tuple):
                    link_start, href = self.current_text.pop()
                    self.markdown.append(f']({href})')
            elif tag == 'ul' or tag == 'ol':
                self.list_level -= 1
                if self.list_level == 0:
                    self.markdown.append('\n')
            elif tag == 'li':
                self.in_list_item = False
                self.markdown.append('\n')
            elif tag == 'p':
                self.markdown.append('\n')
            elif tag == 'strong' or tag == 'b':
                self.markdown.append('**')
            elif tag == 'em' or tag == 'i':
                self.markdown.append('*')

    def handle_data(self, data):
        if self.in_main and data.strip():
            # Clean multiple spaces but preserve line breaks in <pre> tags
            if self.in_pre:
                self.markdown.append(data)
            else:
                cleaned = ' '.join(data.split())
                if cleaned:
                    self.markdown.append(cleaned)

    def get_markdown(self):
        """Returns the generated markdown, cleaned up"""
        text = ''.join(self.markdown)
        # Remove multiple blank lines
        text = re.sub(r'\n{3,}', '\n\n', text)
        return text.strip()


def download_jep(url, timeout=30):
    """Downloads the HTML content of a JEP"""
    try:
        req = urllib.request.Request(
            url,
            headers={'User-Agent': 'Mozilla/5.0 (compatible; JEP-Downloader/1.0)'}
        )
        with urllib.request.urlopen(req, timeout=timeout) as response:
            return response.read().decode('utf-8')
    except urllib.error.HTTPError as e:
        if e.code == 404:
            return None  # JEP no existe
        raise
    except Exception as e:
        print(f"  Error descargando {url}: {e}")
        return None


def html_to_markdown(html):
    """Converts JEP HTML to Markdown format"""
    parser = JEPHTMLToMarkdown()
    parser.feed(html)
    return parser.get_markdown()


def save_jep_as_markdown(jep_number, markdown_content, output_dir):
    """Saves markdown content to a file"""
    filename = f"jep-{jep_number}.md"
    filepath = os.path.join(output_dir, filename)

    with open(filepath, 'w', encoding='utf-8') as f:
        f.write(markdown_content)

    return filepath


def process_jep(url, output_dir):
    """
    Processes a single JEP: downloads, converts, and saves it.
    Returns (filepath, error_message) tuple.
    """
    # Extract JEP number from URL
    jep_number = url.split('/')[-1]

    # Download
    html = download_jep(url)
    if not html:
        return None, f"JEP-{jep_number} not accessible"

    # Convert to markdown
    markdown = html_to_markdown(html)
    if not markdown or len(markdown) < 100:
        return None, f"JEP-{jep_number} empty content"

    # Save
    filepath = save_jep_as_markdown(jep_number, markdown, output_dir)

    return filepath, None


def main():
    urls_file = 'jeps/jep_urls.txt'
    output_dir = 'jeps'
    max_workers = 5  # Limited to avoid overwhelming the server

    print("="*70)
    print("JEPs to Markdown Downloader")
    print("="*70)

    # 1. Verify URLs file exists
    if not os.path.exists(urls_file):
        print(f"Error: File '{urls_file}' not found")
        print("Run first: python3 scrape_jeps_fast.py")
        sys.exit(1)

    # 2. Create output directory
    os.makedirs(output_dir, exist_ok=True)
    print(f"✓ Output directory: {output_dir}/")

    # 3. Read URLs
    with open(urls_file, 'r') as f:
        urls = [line.strip() for line in f if line.strip()]

    print(f"✓ URLs to process: {len(urls)}")
    print(f"✓ Parallel threads: {max_workers}")
    print(f"\nStarting download...\n")

    # 4. Process JEPs in parallel
    successful = 0
    failed = 0
    errors = []

    with ThreadPoolExecutor(max_workers=max_workers) as executor:
        future_to_url = {
            executor.submit(process_jep, url, output_dir): url
            for url in urls
        }

        for i, future in enumerate(as_completed(future_to_url), 1):
            url = future_to_url[future]
            jep_num = url.split('/')[-1]

            try:
                filepath, error = future.result()
                if filepath:
                    successful += 1
                    if i % 10 == 0 or i == len(urls):
                        print(f"  [{i}/{len(urls)}] JEP-{jep_num} ✓")
                else:
                    failed += 1
                    errors.append(error)
                    print(f"  [{i}/{len(urls)}] {error} ✗")
            except Exception as e:
                failed += 1
                error_msg = f"JEP-{jep_num} error: {str(e)}"
                errors.append(error_msg)
                print(f"  [{i}/{len(urls)}] {error_msg} ✗")

            # Pause to avoid overwhelming the server
            time.sleep(0.2)

    # 5. Summary
    print(f"\n{'='*70}")
    print(f"SUMMARY")
    print(f"{'='*70}")
    print(f"  Total processed: {len(urls)}")
    print(f"  Successful: {successful}")
    print(f"  Failed: {failed}")
    print(f"  Output directory: {output_dir}/")

    if errors and len(errors) <= 10:
        print(f"\nErrors:")
        for error in errors:
            print(f"  - {error}")
    elif errors:
        print(f"\nFirst 10 errors:")
        for error in errors[:10]:
            print(f"  - {error}")
        print(f"  ... and {len(errors) - 10} more")

    print(f"\n✓ Process completed")


if __name__ == '__main__':
    main()
