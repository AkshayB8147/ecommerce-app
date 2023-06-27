package com.ecommerce.app.service;

import com.ecommerce.app.dto.response.SignInResponse;
import com.ecommerce.app.dto.user.UserSignInDto;
import com.ecommerce.app.dto.user.UserSignUpDto;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.exceptions.AuthenticationFailException;
import com.ecommerce.app.exceptions.CustomException;
import com.ecommerce.app.repository.UserRepository;
import com.ecommerce.app.service.dao.UserService;
import com.ecommerce.app.service.mappers.UserSignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserSignUpMapper userSignUpMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void userSignUp(UserSignUpDto userDto) {
        if(userRepository.existsByEmail(userDto.getEmail())) {
            throw new CustomException("Email: "+ userDto.getEmail() +" is already in use");
        }
        User user = userRepository.save(userSignUpMapper.apply(userDto));
        authenticationService.generateNewToken(user);
    }

    public SignInResponse userSignIn(UserSignInDto userSignIn) {
        if(!userRepository.existsByEmail(userSignIn.getEmail())) {
            throw new AuthenticationFailException("User not found: " + userSignIn.getEmail());
        } else {
            User user = userRepository.findByEmail(userSignIn.getEmail());
            if(!passwordEncoder.matches(userSignIn.getPassword(), user.getPassword())) {
                throw new AuthenticationFailException("Password invalid");
            }
            return new SignInResponse("success",authenticationService.generateNewToken(user).getToken());
        }

    }
}