package com.global.book.config;

import com.global.book.entity.Author;
import com.global.book.entity.Book;
import com.global.book.service.AuthorService;
import com.global.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setName("Yassir");
        Author author2 = new Author();
        author2.setName("Anass");
        Author author3 = new Author();
        author3.setName("Chaimaa");
        authorService.insertAll(Arrays.asList(author1,author2,author3));

        Book book1 = new Book();
        book1.setName("Java JPA");
        book1.setPrice(200);
        book1.setAuthor(authorService.getOne(1L));

        Book book2 = new Book();
        book2.setName("Data Base Mysql");
        book2.setPrice(300);
        book2.setAuthor(authorService.getOne(1L));

        Book book3 = new Book();
        book3.setName("Python");
        book3.setPrice(120);
        book3.setAuthor(authorService.getOne(2L));

        bookService.insertAll(Arrays.asList(book1,book2,book3));
    }
}
