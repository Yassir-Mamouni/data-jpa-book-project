package com.global.book.service;

import com.global.book.base.BaseRepository;
import com.global.book.base.BaseService;
import com.global.book.entity.Author;
import com.global.book.entity.AuthorSearch;
import com.global.book.repository.AuthorRepo;
import com.global.book.repository.AuthorSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AuthorService extends BaseService<Author,Long> {
    @Autowired
    private AuthorRepo authorRepo;

    public AuthorService(BaseRepository<Author, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Author update(Author entity) {
        Author author = findById(entity.getId());
        author.setName(entity.getName());
        return super.update(author);
    }

    public List<Author> findByAuthorSpec(AuthorSearch authorSearch) {
        AuthorSpec spec = new AuthorSpec(authorSearch);
        return authorRepo.findAll(spec);
    }
}
