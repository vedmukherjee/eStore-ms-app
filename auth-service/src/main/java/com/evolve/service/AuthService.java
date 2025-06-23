package com.evolve.service;

import com.evolve.domain.Usr;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    /*@Autowired
    private UserRepository userRepository;*/
    public Usr getUserById(Long id) {
        return null;//userRepository.findById(id).orElse(null);
    }
    public Usr save(Usr user) {
        return null;//userRepository.save(user);
    }
}