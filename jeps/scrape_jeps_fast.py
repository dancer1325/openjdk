#!/usr/bin/env python3
"""
Extract all JEPs from the official OpenJDK page.
No individual verification (to avoid server blocks).
"""

import re
import urllib.request
import sys


def download_jeps_page():
    """Downloads the JEPs page"""
    print("Downloading JEPs page from https://openjdk.org/jeps/0...")
    try:
        req = urllib.request.Request(
            'https://openjdk.org/jeps/0',
            headers={'User-Agent': 'Mozilla/5.0'}
        )
        with urllib.request.urlopen(req, timeout=30) as response:
            html = response.read().decode('utf-8')
        print(f"✓ Downloaded {len(html)} characters\n")
        return html
    except Exception as e:
        print(f"Error downloading: {e}")
        return None


def extract_jep_numbers_from_html(html):
    """
    Extracts all JEP numbers from HTML.
    Trusts that if it's listed on the official page, it's valid.
    """
    jep_numbers = set()

    # Extract all href="NUMBER" from HTML
    href_pattern = r'href="([0-9]+)"'
    matches = re.findall(href_pattern, html)

    for match in matches:
        jep_numbers.add(int(match))

    return sorted(jep_numbers)


def save_urls_to_file(jep_numbers, output_file):
    """Saves URLs to a file"""
    urls = [f"https://openjdk.org/jeps/{num}" for num in jep_numbers]

    with open(output_file, 'w') as f:
        for url in urls:
            f.write(url + '\n')

    print(f"{'='*70}")
    print(f"✓ File '{output_file}' created successfully")
    print(f"  Total URLs: {len(urls)}")
    if jep_numbers:
        print(f"  Range: JEP-{min(jep_numbers)} to JEP-{max(jep_numbers)}")
    print(f"{'='*70}")


def main():
    output_file = 'jep_urls.txt'
    cached_file = '/tmp/jeps_page.html'

    # 1. Try to use cached file first
    html = None
    try:
        with open(cached_file, 'r') as f:
            html = f.read()
        print(f"✓ Using cached file: {cached_file}")
        print(f"  ({len(html)} characters)\n")
    except FileNotFoundError:
        pass

    # If no cache, download
    if not html:
        html = download_jeps_page()
        if not html:
            print("Could not download page")
            sys.exit(1)

    # 2. Extract JEP numbers
    print("Extracting JEP numbers from HTML...")
    jep_numbers = extract_jep_numbers_from_html(html)
    print(f"✓ Found {len(jep_numbers)} unique JEPs\n")

    if not jep_numbers:
        print("No JEPs found")
        sys.exit(1)

    # 3. Save to file (no verification, trust official page)
    save_urls_to_file(jep_numbers, output_file)

    # 4. Show examples
    print(f"\nFirst 20 generated URLs:")
    for i, jep in enumerate(jep_numbers[:20]):
        print(f"  https://openjdk.org/jeps/{jep}")

    if len(jep_numbers) > 25:
        print(f"  ...")
        print(f"\nLast 5 generated URLs:")
        for jep in jep_numbers[-5:]:
            print(f"  https://openjdk.org/jeps/{jep}")

    print(f"\nNote: All URLs come from the official OpenJDK JEPs page.")
    print(f"      No individual verification to avoid server blocks.")


if __name__ == '__main__':
    main()
