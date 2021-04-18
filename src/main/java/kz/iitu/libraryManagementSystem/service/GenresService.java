package kz.iitu.libraryManagementSystem.service;

import kz.iitu.libraryManagementSystem.entity.Book;
import kz.iitu.libraryManagementSystem.entity.Genres;

import java.util.List;
import java.util.Optional;

public interface GenresService {

    List<Genres> findAllGenres();

    Optional<Genres> findGenreById(long id);

    void createGenre(Genres genre);
}
