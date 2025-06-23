package com.evolve.authwebmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.evolve.controller.UserController;


@SpringBootApplication(scanBasePackages="com.evolve")
@EnableJpaRepositories(basePackages = "com.evolve.repository") // optional if same package
@EntityScan(basePackages = {"com.evolve.domain"}) // optional if same package
@EnableFeignClients(basePackages = "com.evolve.feign")
public class AuthWebApplication {
    @Autowired
    UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(AuthWebApplication.class, args);
	}
}
