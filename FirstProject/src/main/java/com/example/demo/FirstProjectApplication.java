package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
		//ConfigurableApplicationContext context = SpringApplication.run(FirstProjectApplication.class, args);
//		Alien a = context.getBean(Alien.class);
//		a.show();
//		Alien a2 = context.getBean(Alien.class);
//		a2.show();
	}

}
