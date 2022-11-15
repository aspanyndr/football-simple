package com.myexample.footballdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.footballdemo.model.dto.CountryDto;
import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.service.CountryService;

@RestController
@RequestMapping("/football/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping
    public DefaultResponse<CountryDto> saveCountry(@RequestBody CountryDto countryDto ){
        DefaultResponse response = countryService.createCountry(countryDto);
        return response;
    
    }

    @GetMapping
    public List<CountryDto> getCountry(){
        List list = countryService.readAllCountry();
        return list;
    }

    @GetMapping("/{idCountry}")
    public DefaultResponse<CountryDto> getById(@PathVariable Integer idCountry){
        DefaultResponse response = countryService.readIdCountry(idCountry);
        return response;
    }

    @PutMapping
    public DefaultResponse<CountryDto> updateCountry(@RequestBody CountryDto countryDto){
        DefaultResponse response = countryService.updateCountry(countryDto);
        return response;
    }

    @DeleteMapping("/{id}")
    public DefaultResponse deleteById(@PathVariable("id") Integer id) {
        DefaultResponse response = countryService.deleteCountry(id);
        return response;
    }
    
}
