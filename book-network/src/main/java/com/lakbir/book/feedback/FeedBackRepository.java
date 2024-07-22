package com.lakbir.book.feedback;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * lakbir.abderrahim - 22/07/2024
 */
@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, Integer> {

    @Query("""
        SELECT feedback
        FROM Feedback feedback
        WHERE feedback.book.id = :bookId
        """)
    Page<Feedback> findAllByBookId(Integer bookId, Pageable pageable);
}
