package com.cognizant.country_service.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/country")
    public String getCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        com.cognizant.country_service.models.Country country =
            (com.cognizant.country_service.models.Country) context.getBean("country");
        return country.toString();
    }
}
