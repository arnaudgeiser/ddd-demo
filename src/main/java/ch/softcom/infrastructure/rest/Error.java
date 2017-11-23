package ch.softcom.infrastructure.rest;

import lombok.Value;

@Value
public class Error {
    private String message;

    public Error(String message) {
        this.message = message;
    }
}
