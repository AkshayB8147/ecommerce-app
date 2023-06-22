package com.ecommerce.app.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
