package com.evolve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolve.dao.AuthUserRepository;
import com.evolve.domain.Usr;



@RestController
public class AuthRepositoryController {
    @Autowired
    AuthUserRepository userRepository;

    @GetMapping("/hello")
    public String getMsg() {
        return "hello Repo";
    }
     @PostMapping("/users")
    public Usr save(Usr user) {
        return userRepository.save(user);
    }
}

