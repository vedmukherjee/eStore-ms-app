package com.evolve.authrepositorymain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.evolve.controller.AuthRepositoryController;
import com.evolve.model.User;


@SpringBootApplication(scanBasePackages="com.evolve")
public class AuthRepositoryWebApplication {
	@Autowired
	AuthRepositoryController repo;

	public static void main(String[] args) {
		SpringApplication.run(AuthRepositoryWebApplication.class, args);
	}
	@Bean
    public CommandLineRunner demo(AuthRepositoryController repo) {
        return args -> {
            System.out.println(repo.getMsg());
			System.out.println(repo.save(new User(123L,"abc")));
        };
    }

}
