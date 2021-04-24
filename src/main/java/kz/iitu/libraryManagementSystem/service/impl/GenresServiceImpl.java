//package kz.iitu.libraryManagementSystem.service.impl;
//
//import kz.iitu.libraryManagementSystem.entity.Book;
//import kz.iitu.libraryManagementSystem.entity.Genres;
//import kz.iitu.libraryManagementSystem.repository.BookRepository;
//import kz.iitu.libraryManagementSystem.repository.GenresRepository;
//import kz.iitu.libraryManagementSystem.service.GenresService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class GenresServiceImpl implements GenresService {
//
//    @Autowired
//    private GenresRepository genresRepository;
//
//    @Override
//    public List<Genres> findAllGenres() {
//        return genresRepository.findAll();
//    }
//
//    @Override
//    public Optional<Genres> findGenreById(long id) {
//        return genresRepository.findById(id);
//    }
//
//    @Override
//    public void createGenre(Genres genre) {
//        genresRepository.save(genre);
//    }
//}
