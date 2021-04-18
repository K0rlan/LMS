package kz.iitu.libraryManagementSystem.controller;

import kz.iitu.libraryManagementSystem.entity.Genres;
import kz.iitu.libraryManagementSystem.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresService genresService;

    @GetMapping("")
    public List<Genres> getGenres() {
        return genresService.findAllGenres();
    }

    @GetMapping("/{id}")
    public Optional<Genres> getGenreById(@PathVariable("id") long id) { return genresService.findGenreById(id);}

    @PostMapping("")
    public void createGenre(Genres genre) {
        genresService.createGenre(genre);
    }
}
