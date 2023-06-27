package com.ecommerce.app.service;

import com.ecommerce.app.entity.AuthenticationToken;
import com.ecommerce.app.entity.User;
import com.ecommerce.app.exceptions.AuthenticationFailException;
import com.ecommerce.app.repository.TokenRepository;
import com.ecommerce.app.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService  {
    @Autowired
    private TokenRepository tokenRepository;

    public AuthenticationToken saveToken(AuthenticationToken token) {
        return tokenRepository.save(token);
    }

    public AuthenticationToken generateNewToken(User user) {
        return saveToken(new AuthenticationToken(user));

    }

    public User findUserByToken(String token) {
        AuthenticationToken authToken = tokenRepository.findTokenByToken(token);
        if(!Helper.isNull(authToken)) {
            if(!Helper.isNull(authToken.getUser())) {
                return authToken.getUser();
            }
        }
        return null;
    }

    public AuthenticationToken getTokenByUser(User user) {
        return tokenRepository.findTokenByUser(user);
    }

    public void authenticate(String token) {
        if(Helper.isNull(token)) {
            throw new AuthenticationFailException("Authentication token not present");
        }
        if(Helper.isNull(findUserByToken(token))) {
            throw new AuthenticationFailException("Authentication token is invalid");
        }
    }
}
