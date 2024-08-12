package com.bankingmanagement.enterprise;

import org.springframework.boot.SpringApplication;

public class TestBankingmanagementApiEntApplication {

	public static void main(String[] args) {
		SpringApplication.from(BankingmanagementApiEntApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
