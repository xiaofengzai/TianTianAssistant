package com.fa.FinanceAssistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class FinanceAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceAssistantApplication.class, args);
	}
}
