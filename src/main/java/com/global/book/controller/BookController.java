package com.global.book.controller;


import com.global.book.entity.Book;
import com.global.book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }
    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody @Valid Book entity){
        return ResponseEntity.ok(bookService.insert(entity));
    }
    @PutMapping("")
        public ResponseEntity<?> update(@RequestBody @Valid Book entity){
        return ResponseEntity.ok(bookService.update(entity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteByAuthorId(@PathVariable Long id){
        return ResponseEntity.ok(bookService.deleteByAuthorId(id));
    }
}
