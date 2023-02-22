package com.azdevelopment.webproject.exception;

import lombok.Getter;

public enum WebProjectError {

    USER_NOT_FOUND("Usuario não encontrado.");
    @Getter
    private String message;

    WebProjectError(String message) {
        this.message = message;
    }
}
