package com.ecommerce.app.service.dao;

import com.ecommerce.app.entity.User;
import com.ecommerce.app.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User getUserById(Long userId) throws UserNotFoundException;

    public List<User> getAllUsers();

    public User saveUser(User user);

    public List<User> saveUsers(List<User> users);

    public String deleteUserById(Long userId) throws UserNotFoundException ;

    public User updateUser(Long userId, User user) throws UserNotFoundException ;
}
