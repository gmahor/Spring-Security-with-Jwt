package com.gmahor.springsecurityjwtexample.service;

import java.util.List;

import com.gmahor.springsecurityjwtexample.entity.User;
import com.gmahor.springsecurityjwtexample.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // Add User
    public User addUser(User user) {
        return this.userRepo.save(user);
    }

    // Get All User
    public List<User> getAllUsers() {
        return this.userRepo.findAll();
    }

    // get user by username
    public User fetchUserByUsername(String username) {
        return this.userRepo.findByUsername(username);
    }

    // delete single user
    public void deleteUser(int id) {
        this.userRepo.deleteById(id);
    }

}
