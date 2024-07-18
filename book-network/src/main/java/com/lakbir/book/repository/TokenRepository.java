package com.lakbir.book.repository;

import com.lakbir.book.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * lakbir.abderrahim - 15/07/2024
 */
@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

    Optional<Token> findByToken(String token);
}
