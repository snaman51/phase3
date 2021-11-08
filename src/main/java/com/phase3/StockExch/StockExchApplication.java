package com.phase3.StockExch;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.phase3.StockExch.WebSecurityConfiguration;

@Import(WebSecurityConfiguration.class)
@SpringBootApplication
//(scanBasePackages="com.nonJWT.stockexchange.model")
public class StockExchApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockExchApplication.class, args);
	}

}
