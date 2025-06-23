package com.evolve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolve.domain.AuthRequest;
import com.evolve.domain.UserInfo;
import com.evolve.domain.Usr;
import com.evolve.feign.UserRepositoryClient;
import com.evolve.service.AuthService;
import com.evolve.service.JwtService;
import com.evolve.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserController {

    public static final String SECRET = "5367566859703373367639792F423F452848284D6251655468576D5A71347437";

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService userService;
    @Autowired
	private UserRepositoryClient userRepositoryClient;

    @GetMapping("/users/{id}")
    public Usr getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @GetMapping("/user/userProfile")
    public String getMsg(){
        return userRepositoryClient.getMsg();
    }
    @GetMapping("/admin/Profile")
    public String getAdminData(){
        return "Admin Data";
    }
    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }
    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            if (authentication.isAuthenticated()) {
                return jwtService.generateToken(authRequest.getUsername());
            } else {
                throw new UsernameNotFoundException("Invalid user request!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
