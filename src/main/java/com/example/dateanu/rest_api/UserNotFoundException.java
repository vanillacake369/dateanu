package com.example.dateanu.rest_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    // 2xx :: OK
    // 4xx :: Client <== NOT_FOUND
    // 5xx :: Server
    public UserNotFoundException(String message) {
        super(message);
    }
}
