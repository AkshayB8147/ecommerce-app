package com.ecommerce.app.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldId;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldId){
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldId));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldId = fieldId;
    }

}
