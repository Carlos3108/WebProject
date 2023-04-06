package com.azdevelopment.webproject.exception;

import lombok.Getter;

public enum WebProjectError {

    USER_NOT_FOUND("Usuario não encontrado."),
    VALUE_IS_INVALID("Valor invalido.");
    @Getter
    private final String message;

    WebProjectError(String message) {
        this.message = message;
    }
}
