package com.lakbir.book.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * lakbir.abderrahim - 19/07/2024
 */
@Getter
@Setter
@Builder
public class AuthenticateResponse {
    private String token;
}
