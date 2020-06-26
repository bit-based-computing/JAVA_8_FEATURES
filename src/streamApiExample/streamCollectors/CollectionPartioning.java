package streamApiExample.streamCollectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionPartioning {
    public static Boolean isFiction(Book book) {
        if (book.getBookGenres() == BookGenres.HISTORICAL_FICTION || book.getBookGenres() == BookGenres.REALISTIC_FICTION) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Book> books = BookGenerator.createBooks();

        // partitioning by fiction or non-fiction book
        // it return bollean true or false
        // it only make two partition
        Map<Boolean, List<Book>> partitioningByFictionNonFiction = books.stream()
                .collect(Collectors.partitioningBy(CollectionPartioning::isFiction));

        List<Book> fictionBook = partitioningByFictionNonFiction.get(true);
        List<Book> nonfictionBook = partitioningByFictionNonFiction.get(false);
        System.out.println(fictionBook);
        System.out.println(nonfictionBook);
    }
}
