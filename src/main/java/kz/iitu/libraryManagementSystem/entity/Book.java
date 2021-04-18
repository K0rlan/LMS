package kz.iitu.libraryManagementSystem.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private String book_name;
    private String description;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private Author author;

    @ManyToOne
    @JoinColumn(name="genre_id", nullable=false)
    private Genres genres;

    public Book() {

    }

    public Book(String book_name, String description, Author author,  Genres genre) {
        this.book_name = book_name;
        this.description = description;
        this.author = author;
        this.genres = genre;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", genres=" + genres +
                '}';
    }
}
