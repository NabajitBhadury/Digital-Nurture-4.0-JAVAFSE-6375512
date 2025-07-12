package com.cognizant.spring_learn;

import com.cognizant.spring_learn.models.Country;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringLearnApplication {
	static Logger logger;
	public static void main(String[] args) {
		logger = Logger.getLogger(SpringLearnApplication.class.getName());
		SpringApplication.run(SpringLearnApplication.class, args);

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		logger.info(country.toString());
	}
}
