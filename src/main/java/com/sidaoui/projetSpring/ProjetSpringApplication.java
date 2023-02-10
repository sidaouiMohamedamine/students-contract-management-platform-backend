package com.sidaoui.projetSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableScheduling
@EnableAspectJAutoProxy
@EnableWebMvc
@SpringBootApplication
public class ProjetSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetSpringApplication.class, args);
	}

}
