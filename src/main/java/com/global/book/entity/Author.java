package com.global.book.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.book.base.BaseEntity;
import com.global.book.validator.IpAdress;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;
@SQLDelete(sql = "update Authors set is_deleted = true where id= ?")
@Where(clause = "is_deleted = false")
@Entity
@Table(name = "Authors")
public class Author extends BaseEntity<Long> {
    @NotEmpty
    private String name;
    @IpAdress(message = "Should enter a valid ip address")
    private String ipAddress;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
