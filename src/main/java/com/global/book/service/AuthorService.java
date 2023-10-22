package com.global.book.service;

import com.global.book.entity.Author;
import com.global.book.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AuthorService {
    private AuthorRepo authorRepo;
    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }
    public Author findById(Long id){
        return authorRepo.findById(id).orElseThrow();
    }
    public List<Author> findAll(){
        return authorRepo.findAll();
    }
    public Author insert(Author entity){
        if(entity.getId() != null){
            throw new RuntimeException();
        }
        return authorRepo.save(entity);
    }
    public Author update(Author entity){
        Author author = findById(entity.getId());
        author.setName(entity.getName());
        return authorRepo.save(author);
    }
    public void deleteById(Long id){
        authorRepo.deleteById(id);
    }
}
