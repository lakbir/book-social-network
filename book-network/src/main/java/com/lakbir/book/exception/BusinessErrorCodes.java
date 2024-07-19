package com.lakbir.book.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * lakbir.abderrahim - 19/07/2024
 */
public enum BusinessErrorCodes {
    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "No Code"),
    INCORRECT_CURRENT_PASSWORD(300, HttpStatus.BAD_REQUEST,"Current password is incorrect"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, HttpStatus.BAD_REQUEST,"The new password does not match"),
    ACCOUNT_LOCKED(302, HttpStatus.FORBIDDEN, "User Account Is Locked"),
    ACCOUNT_DISABLED(303, HttpStatus.FORBIDDEN, "User Account Is Disabled"),
    BAD_CREDENTIALS(304, HttpStatus.FORBIDDEN, "Login and / ord password is incorrect"),
    ;

    @Getter
    private final int code;

    @Getter
    private final String description;

    @Getter
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
