package com.masai.heybroker.exception;

public class LoginException extends RuntimeException{

    public LoginException() {

    }

    public LoginException(String message) {
        super(message);
    }
}
