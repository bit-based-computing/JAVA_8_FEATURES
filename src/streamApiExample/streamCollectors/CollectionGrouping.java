package streamApiExample.streamCollectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class CollectionGrouping {
    public static String tofullName(Book book) {
        return book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
    }

    public static void main(String[] args) {
        // Collection grouping
        List<Book> books = BookGenerator.createBooks();

        System.out.println("Grouping : ");
        Map<String, List<Book>> booksByAuthor = books.stream()
                .collect(groupingBy(CollectionGrouping::tofullName));
        System.out.println(booksByAuthor);

        // Multilevel grouping
        System.out.println("Multilevel Grouping : ");
        Map<BookGenres, Map<String, List<Book>>> groupByGenersAndAuthorName = books.stream()
                .collect(groupingBy(Book::getBookGenres, groupingBy(CollectionGrouping::tofullName)));
        System.out.println(groupByGenersAndAuthorName);

        // sub grouping
        System.out.println("Sub-Grouping : ");
        Map<BookGenres, Long> countingAuthorBooks = books.stream()
                .collect(groupingBy(Book::getBookGenres, counting()));
        System.out.println(countingAuthorBooks);

        System.out.println("Max priced book of authors : ");
        Map<String, Optional<Book>> maxPriceedBookOfAuthor = books.stream()
                .collect(groupingBy(CollectionGrouping::tofullName, maxBy(Comparator.comparing(Book::getPrice))));
        System.out.println(maxPriceedBookOfAuthor);

        // we can skip optional by using collectingAndThen
        System.out.println("Max priced book without optional : ");
        Map<String, Book> maxPricedBookOfAuthor = books.stream()
                .collect(groupingBy(CollectionGrouping::tofullName,
                        collectingAndThen(maxBy(Comparator.comparingInt(Book::getPrice)), Optional::get)));
        System.out.println(maxPricedBookOfAuthor);

        // we can do it by toMap collector
        Map<String, Book> maxPricedBookMap = books.stream()
                .collect(toMap(CollectionGrouping::tofullName, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Book::getPrice))));
        System.out.println(maxPricedBookMap);


    }
}
