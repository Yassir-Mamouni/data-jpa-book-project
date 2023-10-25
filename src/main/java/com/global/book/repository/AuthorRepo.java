package com.global.book.repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends BaseRepository<Author,Long> {
}
