package com.ecommerce.app.service;

import com.ecommerce.app.entity.User;
import com.ecommerce.app.exceptions.UserNotFoundException;
import com.ecommerce.app.repository.UserRepository;
import com.ecommerce.app.service.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserById(Long userId) throws UserNotFoundException {

        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not available " + userId);
        }
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User updateUser(Long userId,User user) throws UserNotFoundException {
//        User userDB= userRepository.findById(userId).get();
        Optional<User> userDB = userRepository.findById(userId);
        if(!userDB.isPresent()){
            throw new UserNotFoundException("User not available");
        }

        //Verifying username
        if(Objects.nonNull(userDB.get().getName()) && "".equalsIgnoreCase(user.getName())){
            userDB.get().setName(user.getName());
        }

        //Verifying Email
        if(Objects.nonNull(userDB.get().getEmail()) && "".equalsIgnoreCase(user.getEmail())){
            userDB.get().setEmail(user.getEmail());
        }

        //Verifying Phone
        if(Objects.nonNull(userDB.get().getPhone())){
            userDB.get().setPhone(user.getPhone());
        }

        if(Objects.nonNull(userDB.get().getPassword()) && "".equalsIgnoreCase(user.getPassword())){
            userDB.get().setPassword(user.getPassword());
        }

        if(Objects.nonNull(userDB.get().getAddress()) && "".equalsIgnoreCase(user.getAddress())) {
            userDB.get().setAddress(user.getAddress());
        }

        return userRepository.save(userDB.get());
    }

    @Override
    public String deleteUserById(Long userId) throws UserNotFoundException {

        Optional<User> userDB = userRepository.findById(userId);
        if(!userDB.isPresent()){
            throw new UserNotFoundException("User not available " + userId);
        }

        userRepository.deleteById(userId);
        return "User deleted successfully";
    }
}
