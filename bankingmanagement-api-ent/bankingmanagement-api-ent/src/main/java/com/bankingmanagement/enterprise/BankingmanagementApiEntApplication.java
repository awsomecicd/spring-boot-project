package com.bankingmanagement.enterprise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BankingmanagementApiEntApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingmanagementApiEntApplication.class, args);
		log.info("The application build");
		log.debug("ddkslkjj ");
	}

}
