package com.example.capitale.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountriesRepository extends JpaRepository<Countries,Integer> {
    @Query(value = "SELECT c FROM Countries c ORDER BY RANDOM() LIMIT 1")
    Optional<Countries> getRandomCountry();

    @Query(value = "SELECT c.capital FROM Countries c WHERE c.id =:countries_id")
    Optional<Object> findCapitalById(@Param("countries_id") Integer id);
}
