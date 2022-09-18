package com.example.chainOfResponsibility;

import com.example.chainOfResponsibility.service.BatchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChainOfResponsibilityApplication {
	private static BatchService batchService;

	public static void main(String[] args) {
		SpringApplication.run(ChainOfResponsibilityApplication.class, args);
	}

}
