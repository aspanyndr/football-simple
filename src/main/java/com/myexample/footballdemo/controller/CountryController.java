package com.myexample.footballdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.myexample.footballdemo.model.entity.Country;
import com.myexample.footballdemo.repository.CountryRepository;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @PostMapping("/save")
    public DefaultResponse<CountryDto> saveCountry(@RequestBody CountryDto countryDto ){
        Country country = convertDtoToEntity(countryDto);
        DefaultResponse <CountryDto> response = new DefaultResponse<>();
        Optional<Country> optionaCountry = countryRepository.findByIdCountry(countryDto.getIdCountry());

        if(optionaCountry.isPresent()){
            response.setStatus(false);
            response.setMessege("Sorry, country already exist");
            response.setData(countryDto);
        }
        else{
            countryRepository.save(country);
            response.setStatus(true);
            response.setMessege("Country has been saved!");
            response.setData(countryDto);
        }
        return response;    
    }

    @GetMapping("/get")
    public List<CountryDto> getCountry(){
        List <CountryDto> listCountry = new ArrayList<CountryDto>();
        for (Country country : countryRepository.findAll()){
            listCountry.add(convertEntityToDto(country));
        }
        return listCountry;
    }

    @GetMapping("/getId/{id}")
    public DefaultResponse<CountryDto> getById(@PathVariable Integer id){
        DefaultResponse<CountryDto> response = new DefaultResponse<>();
        Optional<Country> optionalCountry = countryRepository.findByIdCountry(id);
        if (optionalCountry.isPresent()){
            response.setStatus(true);
            response.setMessege("Here's your country");
            response.setData(convertEntityToDto(optionalCountry.get()));
        }
        else if( optionalCountry.isEmpty()){
            response.setStatus(false);
            response.setMessege("Your country  it's not found");
        }
        return response;
    }

    @PutMapping("/update/{id}")
    public DefaultResponse<CountryDto> updateCountry(@RequestBody CountryDto countryDto, @PathVariable("id") Integer id){
        DefaultResponse response = new DefaultResponse<>();
        Optional<Country> optionalCountry = countryRepository.findByIdCountry(id);
        Country country = optionalCountry.get();
        if(optionalCountry.isPresent()){
            country.setIdCountry(countryDto.getIdCountry());
            country.setCountryName(countryDto.getCountryName());
            country.setFifaRank(countryDto.getFifaRank());
            country.setIdCountry(countryDto.getIdCountry());

            countryRepository.save(country);
            response.setStatus(true);
            response.setMessege("Country succesfully update");
            response.setData(country);
        }
        else{
            response.setStatus(false);
            response.setMessege("Sorry Country does not exist");
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public DefaultResponse deleteById(@PathVariable("id") Integer id) {
        DefaultResponse response = new DefaultResponse();
        Optional<Country> optionalCountry = countryRepository.findByIdCountry(id);
        if (optionalCountry.isPresent()){
            countryRepository.delete(optionalCountry.get());
            response.setStatus(Boolean.TRUE);
            response.setMessege("Succes deleted club");
            response.setData(optionalCountry);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Failed delete club");
            response.setData(optionalCountry);
        }
        return response;
    }

    public Country convertDtoToEntity(CountryDto countryDto){
        Country country = new Country();

        country.setIdCountry(countryDto.getIdCountry());
        country.setCountryName(countryDto.getCountryName());
        country.setFifaRank(countryDto.getFifaRank());
        return country;
    }

    public CountryDto convertEntityToDto(Country country){
        CountryDto countryDto = new CountryDto();

        countryDto.setIdCountry(country.getIdCountry());
        countryDto.setCountryName(country.getCountryName());
        countryDto.setFifaRank(country.getFifaRank());
        return countryDto;
    }
    
}
