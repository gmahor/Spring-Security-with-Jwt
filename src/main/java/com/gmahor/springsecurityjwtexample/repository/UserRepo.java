package com.gmahor.springsecurityjwtexample.repository;

import com.gmahor.springsecurityjwtexample.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

}
