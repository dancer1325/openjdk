package share.classes.java.util.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPackageInfo {
    public static void main(String[] args) {
        List<String> elements = new ArrayList();
        elements.add("ALfred");
        elements.add("Bingo");

        // 1. If you do NOT specify the type of Stream -> it's NOT inferred the source of elements
        //Stream elementsStream = elements.stream();
        Stream<String> elementsStream = elements.stream();

        String element = elementsStream
                .filter(b -> b.contains("A"))
                .map(b -> b.toLowerCase())
                .findFirst()
                .get();
        System.out.println(element);

        // 2. Streams are functional-related -> source NOT modified (ALWAYS you do NOT make a terminal operation)
        System.out.println(elements.get(0));

        streamsAreConsumable(elementsStream);

        waysToObtainStream(elements, elementsStream);
    }

    private static void streamsAreConsumable(Stream<String> elementsStream) {
        // 3. Streams are consumable
        try {
            System.out.println(elementsStream.collect(Collectors.toList()));
        } catch (IllegalStateException illegalStateException) {
            System.out.println(illegalStateException.getMessage());
        }
    }

    private static void waysToObtainStream(List<String> elements, Stream<String> elementsStream) {
        // 4.1 Collection
        // 4.1.1 .stream()
        isAStream(elementsStream);
        // 4.1.2 Collection.stream()
        isAStream(elements.parallelStream());
        // 4.2 Arrays.stream(Object[])
        var array = elements.toArray((new String[0]));
        isAStream(Arrays.stream(array));
        // 4.3 static factory methods | stream classes
        // 4.3.1 Stream.of(Object[])
        isAStream(Stream.of(array));
        // 4.3.2 IntStream.range(int, int)
        isAStream(IntStream.range(0,10));
        // 4.3.3 Stream.iterate(Object, UnaryOperator)
        isAStream(Stream.iterate(0, n -> n + 2));
        // 4.4 BufferedReader.lines()
        // System.out.println(System.getProperty("user.dir"));          -- way to check the working directory used to trigger it
        try (BufferedReader reader = new BufferedReader(new FileReader("example/java.base/share/classes/java/util/stream/example.txt"))){
            isAStream(reader.lines());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 4.5 java.nio.file.Files
        Path dir = Paths.get("example/java.base/share/classes/java/util/stream");
        try (Stream<Path> paths = Files.list(dir)){
            isAStream(paths);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 4.6 java.util.Random.ints()
        isAStream(new Random().ints());
        // 4.7 stream-bearing methods
        isAStream(new BitSet().stream());
        isAStream(Pattern.compile("ALfred").splitAsStream("Al"));
        try (Stream<JarEntry> stream = new JarFile("example/java.base/share/classes/java/util/stream/StreamPackageInfo.jar").stream()){
            isAStream(stream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isAStream(Object obj) {
        boolean isAStream = obj instanceof BaseStream;
        System.out.println(obj.toString().concat( "is a stream " + isAStream ));
        return isAStream;
    }
}