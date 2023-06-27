package com.ecommerce.app.service.mappers;

import com.ecommerce.app.dto.user.UserSignUpDto;
import com.ecommerce.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserSignUpMapper implements Function<UserSignUpDto, User> {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User apply(UserSignUpDto user) {
        return new User(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                passwordEncoder.encode(user.getPassword())
        );
    }
}
