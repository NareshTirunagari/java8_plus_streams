import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo1 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );

        //print all the numbers using lambda
        numbers.stream()
                .forEach(e -> System.out.println(e));

        System.out.println("*******************************************");

        //print all the numbers using method reference
        numbers.stream()
                .forEach(System.out::println);

        System.out.println("*******************************************");

        //print all even numbers using method reference
        numbers.stream()
                .filter(e -> e%2==0)
                .forEach(System.out::println);

        System.out.println("*******************************************");

        //print all squares of a number
        numbers.stream()
                .map(e -> e*e)
                .forEach(System.out::println);

        System.out.println("*******************************************");

        //for each number return multiples of 5 in a separate list. limit to 3 only.
        numbers.stream()
                .map(e -> List.of(e*5, e*10, e*15))
                .forEach(System.out::println);

        System.out.println("*******************************************");

        //for each number return multiples of 5 in a single list. limit to 3 only for each number.
        numbers.stream()
                .flatMap(e -> List.of(e*5, e*10, e*15).stream())
                .forEach(System.out::println);

        System.out.println("*******************************************");

        numbers.stream()
                .flatMap(e -> Stream.of(e*5, e*10, e*15))
                .forEach(System.out::println);

        System.out.println("*******************************************");



    }
}
