package com.demobank.transaction.transaction_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TransactionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApiApplication.class, args);
	}

}
