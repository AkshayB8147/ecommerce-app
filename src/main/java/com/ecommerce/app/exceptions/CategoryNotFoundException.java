package com.ecommerce.app.exceptions;

public class CategoryNotFoundException extends RuntimeException {
<<<<<<< HEAD
    public CategoryNotFoundException(String message) {
        super(message);
    }
=======
    public CategoryNotFoundException() {
        super();
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryNotFoundException(Throwable cause) {
        super(cause);
    }
>>>>>>> origin/main
}
