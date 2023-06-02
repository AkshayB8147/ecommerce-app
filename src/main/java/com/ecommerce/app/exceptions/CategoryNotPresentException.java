package com.ecommerce.app.exceptions;

public class CategoryNotPresentException extends RuntimeException {
    public CategoryNotPresentException() {
        super();
    }

    public CategoryNotPresentException(String message) {
        super(message);
    }

    public CategoryNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotPresentException(Throwable cause) {
        super(cause);
    }
}
