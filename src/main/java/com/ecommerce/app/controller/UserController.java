package com.ecommerce.app.controller;

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

    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        LOGGER.info("Inside of getUserById in UserController");
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<User>> getAllUsers(){
        LOGGER.info("Inside of getAllUsers in UserController");
        List<User> users= userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @PostMapping(value = "/saveUser")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        LOGGER.info("Inside of saveUser in UserController");
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @PostMapping(value = "")
    public ResponseEntity<List<User>> saveUsers(@Valid @RequestBody List<User> users){
        LOGGER.info("Inside of saveUsers in UserController");
        List<User> savedUsers = userService.saveUsers(users);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId,@Valid @RequestBody User user) {
        LOGGER.info("Inside of updateUser in UserController");
        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable("userId") Long userId) {
        LOGGER.info("Inside of deleteUserById in UserController");
        String message = userService.deleteUserById(userId);
        return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
