package com.myexample.footballdemo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myexample.footballdemo.model.dto.CountryDto;
import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.entity.Country;
import com.myexample.footballdemo.service.CountryService;
import com.myexample.footballdemo.repository.CountryRepository;


@Service
@Transactional
public class CountryServiceImpl implements CountryService{
    
    @Autowired
    CountryRepository countryRepository;

    @Override
    public DefaultResponse createCountry(CountryDto dto) {
        Country country = convertDtoToEntity(dto);
        DefaultResponse <CountryDto> response = new DefaultResponse<>();
        Optional<Country> optionaCountry = countryRepository.findByIdCountry(dto.getIdCountry());

        if(optionaCountry.isPresent()){
            response.setStatus(false);
            response.setMessege("Sorry, country already exist");
            response.setData(dto);
        }
        else{
            countryRepository.save(country);
            response.setStatus(true);
            response.setMessege("Success, Country has been saved!");
            response.setData(dto);
        }
        return response;    

    }

    @Override
    public DefaultResponse deleteCountry(Integer idCountry) {
        DefaultResponse response = new DefaultResponse();
        Optional<Country> optionalCountry = countryRepository.findByIdCountry(idCountry);
        if (optionalCountry.isPresent()){
            countryRepository.delete(optionalCountry.get());
            response.setStatus(Boolean.TRUE);
            response.setMessege("Succes, your country successfully deleted");
            response.setData(optionalCountry);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Failed, your country cannot be found");
            response.setData(optionalCountry);
        }
        return response;
    }
    

    @Override
    public List readAllCountry() {
        List <CountryDto> listCountry = new ArrayList<CountryDto>();
        for (Country country : countryRepository.findAll()){
            listCountry.add(convertEntityToDto(country));
        }
        return listCountry;
    }

    @Override
    public DefaultResponse readIdCountry(Integer idCountry) {
        DefaultResponse<CountryDto> response = new DefaultResponse<>();
        Optional<Country> optionalCountry = countryRepository.findByIdCountry(idCountry);
        if (optionalCountry.isPresent()){
            response.setStatus(true);
            response.setMessege("Found it!, Here's your country");
            response.setData(convertEntityToDto(optionalCountry.get()));
        }
        else if( optionalCountry.isEmpty()){
            response.setStatus(false);
            response.setMessege("Sorry theres a mistake, Your country cannot be found");
        }
        return response;
    }

    @Override
    public DefaultResponse updateCountry(CountryDto dto) {
        DefaultResponse response = new DefaultResponse<>();
        Optional<Country> optionalCountry = countryRepository.findByIdCountry(dto.getIdCountry());
        Country country = optionalCountry.get();
        if(optionalCountry.isPresent()){
            country.setIdCountry(dto.getIdCountry());
            country.setCountryName(dto.getCountryName());
            country.setFifaRank(dto.getFifaRank());
            country.setIdCountry(dto.getIdCountry());

            countryRepository.save(country);
            response.setStatus(true);
            response.setMessege("Success, your Country successfully update");
            response.setData(country);
        }
        else{
            response.setStatus(false);
            response.setMessege("Sorry theres a mistake, Country does not exist");
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
