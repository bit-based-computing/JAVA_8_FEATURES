package streamApiExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// filtering a book list from a book list by stream
public class Book {
    String name;
    String language;
    Long price;

    public Book(String name, String language, Long price) {
        this.name = name;
        this.language = language;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("book1", "bangla", 100L));
        books.add(new Book("book2", "bangla", 200L));
        books.add(new Book("book3", "english", 300L));
        books.add(new Book("book4", "english", 400L));
        books.add(new Book("book5", "arabic", 500L));
        books.add(new Book("book6", "arabic", 600L));
        books.add(new Book("book7", "arabic", 700L));

        String banglaBookNames = books.stream()
                .filter(book -> book.getLanguage().equals("bangla"))
                .map(Book::getName)
                .collect(Collectors.joining(", "));

        System.out.println(banglaBookNames);

        String arabicBookUnder600Price = books.stream()
                .filter(book -> book.getLanguage().equals("arabic"))
                .filter(book -> book.getPrice() <= 600)
                .map(Book::getName)
                .collect(Collectors.joining(", "));

        System.out.println(arabicBookUnder600Price);
    }
}
