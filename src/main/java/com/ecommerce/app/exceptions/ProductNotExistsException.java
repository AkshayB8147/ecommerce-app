package com.ecommerce.app.exceptions;

public class ProductNotExistsException extends RuntimeException {
    public ProductNotExistsException() {
        super();
    }

    public ProductNotExistsException(String message) {
        super(message);
    }

    public ProductNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotExistsException(Throwable cause) {
        super(cause);
    }

}
