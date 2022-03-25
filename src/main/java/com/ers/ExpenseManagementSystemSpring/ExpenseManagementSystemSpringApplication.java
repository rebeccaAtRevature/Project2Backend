package com.ers.ExpenseManagementSystemSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExpenseManagementSystemSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagementSystemSpringApplication.class, args);
	}

}
