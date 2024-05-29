package com.example.capitale.controller;

import com.example.capitale.db.Countries;
import com.example.capitale.service.CountriesDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CountriesController {

    @Autowired
    private CountriesDbService countriesDbService;

    @GetMapping("/countries")
    public ResponseEntity<Object> getRandomCountry() {
        Optional<Countries> country = countriesDbService.getRandomCountry();
        if(country.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(country.get());
    }

    @GetMapping("/countries/{id}/{capital}")
    public ResponseEntity<Object> verifyResponse(@PathVariable("id") Integer id, @PathVariable("capital") String countries) {
        Optional<Object> country = countriesDbService.findCountryById(id);
        if (country.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        System.out.println(country.get() + "/" + countries);
        return ResponseEntity.ok( (country.get().toString().toLowerCase().equals(countries.toLowerCase())) ? country.get() : "Pas la bonne capital");
    }
}
