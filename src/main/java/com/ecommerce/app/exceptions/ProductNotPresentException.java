package com.ecommerce.app.exceptions;

public class ProductNotPresentException extends RuntimeException {
    public ProductNotPresentException() {
        super();
    }

    public ProductNotPresentException(String message) {
        super(message);
    }

    public ProductNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotPresentException(Throwable cause) {
        super(cause);
    }

}
