import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

        //print sum of all the elements of a list
        int sumResult = numbers.stream()
                .reduce(0, (e, carry) -> e+carry);

        System.out.println("sum="+sumResult);
        System.out.println("*******************************************");

        //print sum of the squared numbers of a list that are mutliples of 3
        sumResult =
        numbers.stream()
                .filter(e -> e%3==0)
                .map(e -> e*e)
                .reduce(0, (e, carry) -> e+carry);

        System.out.println("sum="+sumResult);
        System.out.println("*******************************************");

        sumResult =
        numbers.stream()
                .filter((e -> e%5==0))
                .peek(System.out::println)
                .mapToInt(e -> e*e)
                .peek(System.out::println)
                .sum();

        System.out.println("sum="+sumResult);
        System.out.println("*******************************************");

        //double each even number and store into an array
        int[] evenDoubledNumArr = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> e * 2)
                .toArray();

        Arrays.stream(evenDoubledNumArr).forEach(System.out::println);
        System.out.println("*******************************************");

        //double each even number and store into a list
        List<Integer> evenDoubledNumList = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .toList();

        System.out.println("evenDoubledNumList="+evenDoubledNumList);
        System.out.println("*******************************************");

        Set<Integer> evenDoubledNumSet = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(Collectors.toSet());

        System.out.println("evenDoubledNumSet="+evenDoubledNumSet);
        System.out.println("*******************************************");

        //are all even numbers
        List<Integer> numbersList1 = new ArrayList<>(
                Arrays.asList(2, 4, 6, 8, 10)
        );
        boolean areAllEven = numbersList1.stream()
                .allMatch(e -> e % 2 == 0);

        //is any one even
        numbersList1 = new ArrayList<>(
                Arrays.asList(21, 49, 63, 75, 80, 101)
        );
        boolean isAnyOneEven = numbersList1.stream()
                .anyMatch(e -> e%2==0);

        //is any one even
        numbersList1 = new ArrayList<>(
                Arrays.asList(21, 49, 63, 75, 83, 101)
        );
        boolean isNoneEven = numbersList1.stream()
                .noneMatch(e -> e%2==0);

        System.out.println("areAllEven="+areAllEven);
        System.out.println("isAnyOneEven="+isAnyOneEven);
        System.out.println("isNoneEven="+isNoneEven);
        System.out.println("*******************************************");

    }
}
