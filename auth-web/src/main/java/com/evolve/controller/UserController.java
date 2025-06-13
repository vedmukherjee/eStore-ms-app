package com.evolve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.evolve.domain.User;
import com.evolve.feign.UserRepositoryClient;
import com.evolve.service.AuthService;

@RestController
public class UserController {

    @Autowired
    private AuthService userService;
    @Autowired
	private UserRepositoryClient userRepositoryClient;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/hello")
    public String getMsg(){
        return userRepositoryClient.getMsg();
    }
}
