package com.gmahor.springsecurityjwtexample.controller;

import com.gmahor.springsecurityjwtexample.entity.AuthRequest;
import com.gmahor.springsecurityjwtexample.entity.User;
import com.gmahor.springsecurityjwtexample.service.UserService;
import com.gmahor.springsecurityjwtexample.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to gourav";
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userService.addUser(user);
    }

    @PostMapping("/generate-token")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            log.info(".........Token gentrated successfully.........");
        } catch (Exception e) {
            throw new Exception("invaild username/password");
        }

        return jwtUtil.generateToken(authRequest.getUsername());
    }
}
