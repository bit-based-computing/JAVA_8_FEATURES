package streamApiExample.streamCollectors;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CollectionJoining {
    public static void main(String[] args) {
        // using string joiner
        StringJoiner stringJoiner = new StringJoiner(", ");
        List<Book> bookList = BookGenerator.createBooks();
        for(Book book: bookList){
            stringJoiner.add(book.getName());
        }
        System.out.println(stringJoiner);

        // we can set delimiter, prefix, suffix
        StringJoiner joiner = new StringJoiner(", ", "[ "," ]");
        for(Book book : bookList){
            joiner.add(book.getName());
        }
        System.out.println(joiner);

        // we can do it by declarative way
        String booksName = bookList.stream()
                .map(Book::getName)
                .collect(Collectors.joining(", ", "[ ", " ]"));
        System.out.println(booksName);

    }
}
