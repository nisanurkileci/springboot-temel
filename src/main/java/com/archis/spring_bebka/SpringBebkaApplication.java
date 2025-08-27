package com.archis.spring_bebka;

import com.archis.spring_bebka.service.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBebkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBebkaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext ctx) {
		return args -> {
			MessageService messageService = ctx.getBean(MessageService.class);
			messageService.processMessage();
		};
	}
}
