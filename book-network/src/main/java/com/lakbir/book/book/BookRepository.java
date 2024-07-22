package com.lakbir.book.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * lakbir.abderrahim - 20/07/2024
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {

    @Query("""
        SELECT book
        FROM Book book
        WHERE book.archived = false 
        AND book.shareable = true 
        AND book.owner.id != :userId
    """)
    Page<Book> findAllDisplayedBooks(Pageable pageable, Integer userId);
}
