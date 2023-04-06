package com.azdevelopment.webproject.exception;

import lombok.Getter;

public enum WebProjectError {

    USER_NOT_FOUND("User not found."),
    VALUE_IS_INVALID("Invalid value.");
    @Getter
    private final String message;

    WebProjectError(String message) {
        this.message = message;
    }
}
