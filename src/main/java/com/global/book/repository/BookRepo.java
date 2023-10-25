package com.global.book.repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends BaseRepository<Book,Long> {
    @Override
    @EntityGraph(attributePaths = {"author"})
    Optional<Book> findById(Long aLong);

    @Override
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAll();
    @Transactional
    @Modifying
    @Query("delete from Book where author.id = :id")
    int deleteByAuthorId(Long id);


}
