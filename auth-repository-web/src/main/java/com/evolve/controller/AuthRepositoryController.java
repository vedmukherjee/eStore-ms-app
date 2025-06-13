package com.evolve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolve.model.User;



@RestController
public class AuthRepositoryController {
    /*@Autowired
    UserRepository userRepository;*/

    @GetMapping("/hello")
    public String getMsg() {
        return "hello Repo";
    }
     @PostMapping("/users")
    public User save(User user) {
        return null;//userRepository.save(user);
    }
}

