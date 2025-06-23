package com.evolve.authrepositorymain;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.h2.tools.Server;

import com.evolve.controller.AuthRepositoryController;
import com.evolve.domain.Usr;


@SpringBootApplication(scanBasePackages="com.evolve")
@EnableJpaRepositories(basePackages = "com.evolve.dao") // optional if same package
@EntityScan(basePackages = {"com.evolve.domain"}) // optional if same package
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
			System.out.println(repo.save(new Usr(123L,"abc")));
        };
    }
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
		return Server.createTcpServer(
		"-tcp", "-tcpAllowOthers", "-tcpPort", "8090");
	}
	// Enable Web server (H2 Console) over HTTP
    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2WebServer() throws SQLException {
        return Server.createWebServer(
                "-web", "-webAllowOthers", "-webPort", "8082");
    }
}
