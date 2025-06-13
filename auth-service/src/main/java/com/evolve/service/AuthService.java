package com.evolve.service;

import com.evolve.domain.User;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    /*@Autowired
    private UserRepository userRepository;*/
    public User getUserById(Long id) {
        return null;//userRepository.findById(id).orElse(null);
    }
    public User save(User user) {
        return null;//userRepository.save(user);
    }
}