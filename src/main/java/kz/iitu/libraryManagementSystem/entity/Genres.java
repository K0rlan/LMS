package kz.iitu.libraryManagementSystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genre_id;
    private String genre_name;

    @OneToMany(mappedBy="genres", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Book> books = new ArrayList<>();

    public Genres(String genre_name) {
        this.genre_name = genre_name;
    }

    public Genres() {
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "genre_id=" + genre_id +
                ", genre_name='" + genre_name +
                '}';
    }
}
