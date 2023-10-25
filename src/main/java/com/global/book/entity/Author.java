package com.global.book.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.book.base.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Authors")
public class Author extends BaseEntity<Long> {

    private String name;
    @Formula("(select count(*) from books book where book.author_id=id)")
    private long bookCount;
    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private List<Book> books =  new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }
    public void removeBook(Book book){
        books.remove(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }

}
