package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Genres;
import kz.iitu.libraryManagementSystem.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GenresController {

    @Autowired
    private GenresService genresService;

    public List<Genres> getGenres() {
        return genresService.findAllGenres();
    }

    public Optional<Genres> getGenreById(long id) { return genresService.findGenreById(id);}

    public void createGenre(Genres genre) {
        genresService.createGenre(genre);
    }
}
