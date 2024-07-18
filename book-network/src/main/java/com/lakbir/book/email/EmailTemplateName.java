package com.lakbir.book.email;

import lombok.Getter;

/**
 * lakbir.abderrahim - 18/07/2024
 */
@Getter
public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("activate_account");
    private final String name;

    EmailTemplateName(String name) {
        this.name = name;
    }
}
