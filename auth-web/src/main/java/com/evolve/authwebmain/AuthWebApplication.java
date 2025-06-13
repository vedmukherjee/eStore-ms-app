package com.evolve.authwebmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.evolve.controller.UserController;


@SpringBootApplication(scanBasePackages="com.evolve")
@EnableFeignClients(basePackages = "com.evolve.feign")
public class AuthWebApplication {
    @Autowired
    UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(AuthWebApplication.class, args);
	}
}
