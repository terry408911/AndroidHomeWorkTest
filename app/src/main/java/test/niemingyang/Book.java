package test.niemingyang;

/**
 * Created by terry on 12/16/15.
 */
public class Book {
    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private String desp;

    public Book() {
    }

    public Book(String author, String publisher, String isbn, String name, String desp) {
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.name = name;
        this.desp = desp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
