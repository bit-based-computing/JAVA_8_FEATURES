package streamApiExample;

import java.util.List;

public class DistinctExample {
    public static void main(String[] args) {
        // it only return distinct item from list
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5);
        numbers.stream().distinct().forEach(System.out::println);
    }
}
