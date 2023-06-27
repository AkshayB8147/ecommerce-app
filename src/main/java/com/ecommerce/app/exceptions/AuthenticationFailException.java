package com.ecommerce.app.exceptions;

public class AuthenticationFailException extends RuntimeException {

    public AuthenticationFailException(String msg) {
        super(msg);
    }

}
