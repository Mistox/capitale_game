package com.example.capitale.service;

import com.example.capitale.db.Countries;
import com.example.capitale.db.CountriesInterface;
import com.example.capitale.db.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountriesDbService implements CountriesInterface {

    @Autowired
    private CountriesRepository countriesRepository;

    public Optional<Countries> getRandomCountry() {
        return countriesRepository.getRandomCountry();
    }

    public Optional<Object> findCountryById(Integer id) {
        return countriesRepository.findCapitalById(id);
    }
}
