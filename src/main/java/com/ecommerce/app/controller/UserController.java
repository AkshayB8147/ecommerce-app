package com.ecommerce.app.controller;

import com.ecommerce.app.dto.response.ApiResponse;
import com.ecommerce.app.dto.response.SignInResponse;
import com.ecommerce.app.dto.user.UserSignInDto;
import com.ecommerce.app.dto.user.UserSignUpDto;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.service.dao.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<ApiResponse> userSignUp(@Valid @RequestBody UserSignUpDto userSignUp){
        userService.userSignUp(userSignUp);
        return new ResponseEntity<>(new ApiResponse(true, "User create successully"),HttpStatus.CREATED);
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<SignInResponse> userSignIn(@Valid @RequestBody UserSignInDto userSignIn){
        return new ResponseEntity<>(
                userService.userSignIn(userSignIn),
                HttpStatus.OK
        );
    }
}
