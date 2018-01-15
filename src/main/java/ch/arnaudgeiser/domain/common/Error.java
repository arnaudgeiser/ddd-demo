package ch.arnaudgeiser.domain.common;

import lombok.Value;

@Value
public class Error {
    private String message;

    public Error(String message) {
        this.message = message;
    }
}
