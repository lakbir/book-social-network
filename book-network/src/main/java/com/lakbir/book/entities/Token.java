package com.lakbir.book.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * lakbir.abderrahim - 15/07/2024
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;
    private String token;
    private LocalDateTime createAt;
    private LocalDateTime expiresAt;
    private LocalDateTime validatedAt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
