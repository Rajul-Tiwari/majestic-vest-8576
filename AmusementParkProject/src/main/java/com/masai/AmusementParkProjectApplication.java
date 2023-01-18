package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.masai")
public class AmusementParkProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmusementParkProjectApplication.class, args);
	}

}
