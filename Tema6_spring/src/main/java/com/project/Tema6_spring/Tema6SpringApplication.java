package com.project.Tema6_spring;

import com.project.Tema6_spring.model.User;
import com.project.Tema6_spring.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableAspectJAutoProxy
@Component
public class Tema6SpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Tema6SpringApplication.class, args);
	}

	private final UserService userService;

	public Tema6SpringApplication(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Create here some users, insurances and display them");
		userService.create(new User(999, "Test"));
	}
}
