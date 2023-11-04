package com.global.book.controller;

import com.global.book.entity.Author;
import com.global.book.entity.AuthorSearch;
import com.global.book.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(authorService.findById(id));
    }
    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(authorService.findAll());
    }
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody @Valid Author entity){

        return ResponseEntity.ok(authorService.insert(entity));
    }
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author entity){
        return ResponseEntity.ok(authorService.update(entity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
       authorService.deleteById(id);
       return ResponseEntity.ok(null);
    }
    @PostMapping("/spec")
    public ResponseEntity<?> findByAuthorSpec(@RequestBody AuthorSearch authorSearch){
        return ResponseEntity.ok(authorService.findByAuthorSpec(authorSearch));
    }
}
