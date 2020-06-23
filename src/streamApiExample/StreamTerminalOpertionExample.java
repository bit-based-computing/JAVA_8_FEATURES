package streamApiExample;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTerminalOpertionExample {
    public static void main(String[] args) {
        // long count()
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Stream count operation : integer list item count = " + integerList.stream().count());

        // forEach parallel . it does not maintain item order because it run by thread
        // thread maintain by operating system
        integerList.stream().parallel().forEach(item ->
                System.out.print(item + ", ")
        );
        System.out.println();

        //forEachOrdered parallel maintain item order
        System.out.println("Print by forEachOrdered");
        integerList.stream().parallel().forEachOrdered(item -> System.out.print(item + ", "));
        System.out.println();
        // toArray function
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        Object[] integers = integerStream.toArray();

        // min() max()
        Optional<Integer> min = integerList.stream().min(Comparator.comparing(Integer::valueOf));
        min.ifPresent(System.out::println);

        Optional<Integer> max = integerList.stream().max(Comparator.comparing(Integer::valueOf));
        max.ifPresent(System.out::println);

        // anyMatch(), allMatch(), noneMatch(), findAny(), findFirst()
        // all are take predicate funtionalInteface
        boolean anyMatch = integerList.stream().anyMatch(i -> i < 10);
        System.out.println("anyMathc : " + anyMatch);

        // if all item true this condition then return true or return false
        boolean allMatch = integerList.stream().allMatch(i -> i % 2 == 0);
        System.out.println("allMatch : " + allMatch);

        // if all item not match this condition then return true or return false
        boolean nonMatch = integerList.stream().noneMatch(i -> i > 10);
        System.out.println("nonMatch : " + nonMatch);

        Optional<Integer> findAny = integerList
                .stream()
                .filter(i -> i % 2 == 0)
                .findAny();

        findAny.ifPresent(System.out::println);

        Optional<Integer> findFirst = integerList
                .stream()
                .filter(i -> i % 2 == 0)
                .filter(i -> i >= 4)
                .findFirst();
        findFirst.ifPresent(System.out::println);

        // reduce
        int sum = integerList.stream()
                .reduce(0,(a,b)-> Integer.sum(a,b));
        System.out.println(sum);

        int product = integerList.stream()
                .reduce(1,(a,b)-> a*b);
        System.out.println(product);

    }
}
