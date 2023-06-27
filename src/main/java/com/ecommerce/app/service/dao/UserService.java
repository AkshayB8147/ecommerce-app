package com.ecommerce.app.service.dao;

import com.ecommerce.app.dto.response.SignInResponse;
import com.ecommerce.app.dto.user.UserSignInDto;
import com.ecommerce.app.dto.user.UserSignUpDto;

import java.util.List;

public interface UserService {

    void userSignUp(UserSignUpDto user);

    SignInResponse userSignIn(UserSignInDto user);

}
