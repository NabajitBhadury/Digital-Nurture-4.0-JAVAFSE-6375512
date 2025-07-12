package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringLearnApplication {
	static Logger logger;
	public static void main(String[] args) {
		logger = Logger.getLogger(SpringLearnApplication.class.getName());
		SpringApplication.run(SpringLearnApplication.class, args);
		logger.info("SpringLearnApplication started successfully.");
	}
}
