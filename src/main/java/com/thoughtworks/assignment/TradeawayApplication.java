package com.thoughtworks.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan( basePackages = {
		"com.thoughtworks.assignment.domain"
})
@EnableJpaRepositories( basePackages = {
		"com.thoughtworks.assignment.repository"
})
public class TradeawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeawayApplication.class, args);
	}
}
