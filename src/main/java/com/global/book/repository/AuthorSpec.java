package com.global.book.repository;

import com.global.book.entity.Author;
import com.global.book.entity.AuthorSearch;
import com.global.book.entity.Book;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Predicates;

import java.util.ArrayList;
import java.util.List;

public class AuthorSpec implements Specification<Author> {
    private AuthorSearch authorSearch;

    public AuthorSpec(AuthorSearch authorSearch) {
        this.authorSearch = authorSearch;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();
        Join<Author, Book> bookJoin = root.join("books",JoinType.LEFT);

        if (authorSearch.getAuthorName() != null && !authorSearch.getAuthorName().isEmpty()) {
            predicates.add(cb.equal(root.get("name"), authorSearch.getAuthorName()));
        }
        if (authorSearch.getEmail() != null && !authorSearch.getEmail().isEmpty()) {
            predicates.add(cb.like(root.get("email"), authorSearch.getEmail()));
        }
        if (authorSearch.getIpAddress() != null && !authorSearch.getIpAddress().isEmpty()) {
            predicates.add(cb.like(root.get("ipAddress"),"%" + authorSearch.getIpAddress()+ "%"));
        }
        if (authorSearch.getBookName()!= null && !authorSearch.getBookName().isEmpty()){
            predicates.add(cb.like(bookJoin.get("name"),"%" + authorSearch.getBookName()+"%"));
        }
        if (authorSearch.getPrice()!= null ){
            predicates.add(cb.greaterThanOrEqualTo(bookJoin.get("price"),authorSearch.getPrice()));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
