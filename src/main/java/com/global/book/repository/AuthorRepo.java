package com.global.book.repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends BaseRepository<Author,Long> , JpaSpecificationExecutor<Author> {
//    @Transactional
//    @Query(value = "update Author a SET a.isDeleted = false WHERE a.id = ?1")
//    @Modifying
//    public void restoredById(Long id);
}
