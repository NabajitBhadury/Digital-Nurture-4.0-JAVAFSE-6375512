package com.cognizant.country_service.controllers;

import com.cognizant.country_service.models.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/country")
    public String getCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        com.cognizant.country_service.models.Country country =
            (com.cognizant.country_service.models.Country) context.getBean("country");
        return country.toString();
    }

    @GetMapping("/country/{code}")
    public String getCountryByCode(@PathVariable String code) {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = (List<Country>) context.getBean("countryList");
        for (Country country : countries) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country.toString();
            }
        }
        return "Country with code " + code + " not found.";
    }
}
