package com.example.demoauth.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DiplomaCoreException extends RuntimeException {

    HttpStatus status;
    String code;

    public DiplomaCoreException(HttpStatus status, String code, String message) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public DiplomaCoreException(String message, HttpStatus status, String code, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.code = code;
    }
}