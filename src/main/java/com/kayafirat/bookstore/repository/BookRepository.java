package com.kayafirat.bookstore.repository;

import com.kayafirat.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Modifying
    @Query(value ="DELETE FROM book where book_id=:bookId", nativeQuery = true)
    void deleteById(@Param("bookId") long bookId);


}
