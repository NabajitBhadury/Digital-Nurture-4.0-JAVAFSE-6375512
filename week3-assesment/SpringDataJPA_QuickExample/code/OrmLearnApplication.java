package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main method of OrmLearnApplication");
		countryService = context.getBean(CountryService.class);
		LOGGER.info("CountryService bean initialized successfully");
		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Inside testGetAllCountries");
		try {
			List<Country> countries = countryService.getAllCountries();

			LOGGER.info("All countries found");
			for (Country country : countries) {
				LOGGER.info("Country Code: {}, Country Name: {}", country.getCode(), country.getName());
			}
		} catch (Exception e) {
			LOGGER.error("Error fetching countries", e);
		}
	}

}
