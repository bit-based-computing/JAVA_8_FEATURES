package streamApiExample;

import java.util.List;
import java.util.stream.Stream;

public class FilterExample {
    public static void main(String[] args) {
        // filter take an Predicate type argument which return only true or false
        // Stream<T> filter(Predicate<? Super T> predicate)

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // even number print
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(val -> System.out.print(val + ", "));
        System.out.println();

        // odd number and less then 6
        numbers.stream()
                .filter(n -> n % 2 != 0)
                .filter(n -> n < 6)
                .forEach(System.out::println);
    }
}
