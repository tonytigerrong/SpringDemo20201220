package com.spring20201220.exception;

public class EmailValidationException extends Exception {
    public EmailValidationException(String message) {
        super(message);
    }
}
