package com.global.book.base;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BaseRepository <T extends BaseEntity<ID>,ID extends Number> extends JpaRepository<T,ID> {
    @Modifying
    @Transactional
    @Query("update #{#entityName} t SET t.statusCode = :statusCode WHERE t.id = :id")
    void updateEntity(@Param("id") Long id , @Param("statusCode") String statusCode);
}
