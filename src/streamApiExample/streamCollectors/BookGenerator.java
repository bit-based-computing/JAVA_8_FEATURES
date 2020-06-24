package streamApiExample.streamCollectors;

import java.util.List;

public class BookGenerator {
    public static List<Book> createBooks() {
        Author foysal = new Author("Foysal", "Ahmmed");
        Author shipon = new Author("shipon", "hossain");
        return List.of(
                new Book("Nondito", 90, foysal, true, BookGenres.REALISTIC_FICTION),
                new Book("Bangla", 200, shipon, false, BookGenres.REALISTIC_FICTION),
                new Book("English", 50, shipon, true, BookGenres.HISTORICAL_FICTION),
                new Book("Math", 100, foysal, true, BookGenres.REALISTIC_FICTION),
                new Book("Religion", 250, foysal, false, BookGenres.REFERENCE_BOOK),
                new Book("Sociology", 150, shipon, true, BookGenres.REALISTIC_FICTION),
                new Book("Science", 200, shipon, true, BookGenres.MYSTERY),
                new Book("Story", 100, foysal, false, BookGenres.HISTORICAL_FICTION),
                new Book("Biology", 180, shipon, true, BookGenres.REALISTIC_FICTION),
                new Book("HigherMath", 250, foysal, true, BookGenres.REFERENCE_BOOK)
                );
    }
}
