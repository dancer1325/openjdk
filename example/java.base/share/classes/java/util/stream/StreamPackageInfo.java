package share.classes.java.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

        // 2. Streams are functional-related -> source NOT modified
        System.out.println(elements.get(0));

        // 3. Streams are consumable
        try {
            System.out.println(elementsStream.collect(Collectors.toList()));
        } catch (IllegalStateException illegalStateException) {
            System.out.println(illegalStateException.getMessage());
        }

    }
}