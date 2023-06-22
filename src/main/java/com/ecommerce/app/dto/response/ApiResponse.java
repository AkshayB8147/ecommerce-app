package com.ecommerce.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean success;
    private String message;

    public String getTimeStamp(){
        return new Date(System.currentTimeMillis()).toString();
    }
}
