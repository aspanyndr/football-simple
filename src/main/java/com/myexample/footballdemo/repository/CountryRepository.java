package com.myexample.footballdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexample.footballdemo.model.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

    Optional<Country> findByIdCountry(Integer idCountry);
    
}
