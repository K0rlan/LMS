package kz.iitu.libraryManagementSystem.repository;

import kz.iitu.libraryManagementSystem.entity.Author;
import kz.iitu.libraryManagementSystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
