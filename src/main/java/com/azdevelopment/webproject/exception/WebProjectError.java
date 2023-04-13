package com.azdevelopment.webproject.exception;

import lombok.Getter;

public enum WebProjectError {

    USER_NOT_FOUND("User not found."),

    ERROR_CREATING("When creating the user the ID must be Null"),

    ERROR_UPDATE("When updating the user, the ID must be filled in."),

    VALUE_IS_INVALID("Invalid value.");
    @Getter
    private final String message;

    WebProjectError(String message) {
        this.message = message;
    }
}
