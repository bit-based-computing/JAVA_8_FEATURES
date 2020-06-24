package streamApiExample.streamCollectors;

public class Book {
    private String name;
    private int price;
    private Author author;
    private boolean fiction;
    private BookGenres bookGenres;
    private int rating;

    public Book(String name, int price, Author author, boolean fiction, BookGenres bookGenres) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.fiction = fiction;
        this.bookGenres = bookGenres;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Book setPrice(int price) {
        this.price = price;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public boolean isFiction() {
        return fiction;
    }

    public Book setFiction(boolean fiction) {
        this.fiction = fiction;
        return this;
    }

    public BookGenres getBookGenres() {
        return bookGenres;
    }

    public Book setBookGenres(BookGenres bookGenres) {
        this.bookGenres = bookGenres;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
