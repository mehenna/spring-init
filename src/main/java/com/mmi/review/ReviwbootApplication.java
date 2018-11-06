package com.mmi.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mmi")
public class ReviwbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviwbootApplication.class, args);
	}
}
