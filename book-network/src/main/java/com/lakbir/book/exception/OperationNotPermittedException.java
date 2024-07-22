package com.lakbir.book.exception;

/**
 * lakbir.abderrahim - 20/07/2024
 */
public class OperationNotPermittedException extends RuntimeException{
    public OperationNotPermittedException(String msg) {
        super(msg);
    }
}
