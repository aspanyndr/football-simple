package com.myexample.footballdemo.service;

import com.myexample.footballdemo.model.dto.ClubDto;
import com.myexample.footballdemo.model.dto.CountryDto;
import com.myexample.footballdemo.model.dto.DefaultResponse;

import java.util.List;

public interface ClubService {

    DefaultResponse createClub(ClubDto clubDto);
    DefaultResponse readIdClub(Integer idClub);
    List readAllClub();
    DefaultResponse deleteClub(Integer idClub);
    DefaultResponse updateClub(ClubDto clubDto);
}
