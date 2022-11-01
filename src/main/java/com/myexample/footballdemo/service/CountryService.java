package com.myexample.footballdemo.service;

import java.util.List;

import com.myexample.footballdemo.model.dto.CountryDto;
import com.myexample.footballdemo.model.dto.DefaultResponse;

public interface CountryService {

    DefaultResponse createCountry(CountryDto dto);
    DefaultResponse readIdCountry(Integer idCountry);
    List readAllCountry();
    DefaultResponse deleteCountry(Integer idCountry);
    DefaultResponse updateCountry(CountryDto dto);


    
}
