package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(User user) {
        return userRepository.createUser(user);
    }

    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        return userRepository.getAllUsers();
    }

    public User getUserById(String id) throws ExecutionException, InterruptedException {
        return userRepository.getUserById(id);
    }

    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public boolean deleteUser(String id) {
        return userRepository.deleteUser(id);
    }
}
