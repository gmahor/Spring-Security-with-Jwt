package com.gmahor.springsecurityjwtexample.controller;

import java.util.List;

import com.gmahor.springsecurityjwtexample.entity.User;
import com.gmahor.springsecurityjwtexample.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllTheUser() {
        return this.userService.getAllUsers();
    }
}
