package com.example.scheduleproject.domain.user.exception;

public class PasswordMismatchedException extends RuntimeException {
    public PasswordMismatchedException(String message) {
        super(message);
    }
}
