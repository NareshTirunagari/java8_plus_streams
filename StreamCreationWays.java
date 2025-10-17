import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationWays {
    public static void main(String[] args) {
        //from collections

        //creating a stream from a list
        var myList = List.of("a", "c", "e", "g", "h");
        var streamFromList = myList.stream();
        //var streamFromList = List.of("a", "c", "e", "g", "h").stream();
        streamFromList.forEach(item -> {
            var upperItem = item.transform(s -> s.toUpperCase());
            System.out.println(item+"==>>"+upperItem);
        });

        //creating a stream from a set
        var mySet = Set.of(1,2, 3, 4, 5);
        var streamFromSet = mySet.stream();
        //var streamFromSet = Set.of(1,2, 3, 4, 5).stream()
        streamFromSet.forEach(e -> System.out.print(e+" "));
        System.out.println();

        //creating a stream from a map
        var myMap = Map.of("a", 1, "b", 2, "c", 3, "d", 4);
        //from map's keys
        var keyStream = myMap.keySet().stream();
        keyStream.forEach(System.out::println);

        //from map's values
        var valueSteam = myMap.values().stream();
        valueSteam.forEach(System.out::println);

        //from map's entryset
        var entrySetStream = myMap.entrySet().stream();
        entrySetStream.forEach(System.out::println);

        //creating a stream from string arrays
        String[] myArrays = {"a", "b", "c"};
        var myArraysStream = Arrays.stream(myArrays);
        myArraysStream.forEach(System.out::println);

        //creating a stream from primitive arrays
        int[] myNums = {1, 2, 3};
        var myNumsStream = Arrays.stream(myNums);
        //IntStream intStream = Arrays.stream(myNums);
        myNumsStream.forEach(System.out::println);

        //creating a stream from Stream's Static Factory Methods
        Stream<String> elementStream = Stream.of("A", "B", "C");
        elementStream.forEach(System.out::println);

        //empty stream
        var emptyStream = Stream.empty();

        //generate some random UUID number which can be used as a correlationId.
        var randomUuidStream = Stream.generate(UUID::randomUUID).limit(5);
        randomUuidStream.forEach(System.out::println);

        //stream of sequential  using limit
        Stream<Integer> iterativeStream1 = Stream.iterate(1, n -> n+1).limit(10);
        iterativeStream1.forEach(System.out::println);

        //stream of seqential numbers using a condition
        Stream<Integer> iterativeStream2 = Stream.iterate(1, n->n<=10, n->n+1);
        iterativeStream2.forEach(System.out::println);

        //stream using range
        IntStream intStream1 = IntStream.range(1, 6);
        intStream1.forEach(System.out::println);

        IntStream intStream2 = IntStream.rangeClosed(1, 6);
        intStream2.forEach(System.out::println);










    }
}
