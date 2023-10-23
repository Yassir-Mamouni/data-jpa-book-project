package com.global.book.repository;

import com.global.book.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    @Override
    @EntityGraph(attributePaths = {"author"})
    Optional<Book> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAll();
}
