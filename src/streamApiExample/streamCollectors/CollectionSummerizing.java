package streamApiExample.streamCollectors;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class CollectionSummerizing {
    public static void main(String[] args) {
        // counting example
        List<Book> books = BookGenerator.createBooks();
        Long totalBooks = books.stream().collect(counting());
        System.out.println("totalBooks : " + totalBooks);

        Long numberOfReferenceBook = books.stream()
                .filter(book -> book.getBookGenres() == BookGenres.REFERENCE_BOOK)
                .collect(counting());
        System.out.println("numberOfReferenceBook : " + numberOfReferenceBook);

        Long totalPriceOfReferenceBook = books.stream()
                .filter(book -> book.getBookGenres() == BookGenres.REFERENCE_BOOK)
                .collect(summingLong(Book::getPrice));
        System.out.println("totalPriceOfReferenceBook : " + totalPriceOfReferenceBook);

        Double averagePrice = books.stream()
                .collect(averagingDouble(Book::getPrice));
        System.out.println("Average Price : " + averagePrice);

        IntSummaryStatistics statistics = books.stream()
                .collect(summarizingInt(Book::getPrice));
        System.out.println(statistics);

        Optional<Book> mostExpensiveBook = books.stream()
                .collect(maxBy(Comparator.comparingDouble(Book::getPrice)));
        mostExpensiveBook.ifPresent(System.out::println);





    }

}
