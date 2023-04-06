package com.azdevelopment.webproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class WebProjectException extends Exception {
    public WebProjectException(WebProjectError message) {
        super(message.getMessage());
    }
}
