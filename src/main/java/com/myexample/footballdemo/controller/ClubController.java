package com.myexample.footballdemo.controller;

import com.myexample.footballdemo.model.entity.Country;
import com.myexample.footballdemo.repository.CountryRepository;
import com.myexample.footballdemo.repository.PlayerRepository;
import com.myexample.footballdemo.repository.PositionRepository;
import com.myexample.footballdemo.service.ClubService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.footballdemo.model.dto.ClubDto;
import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.entity.Club;
import com.myexample.footballdemo.repository.ClubRepository;

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

@RestController
@RequestMapping("/football/club")
public class ClubController {

    @Autowired
    ClubService clubService;

    @PostMapping
    public DefaultResponse<ClubDto> saveClub(@RequestBody ClubDto clubDto){
        DefaultResponse response = clubService.createClub(clubDto);
        return response;
    }

    @GetMapping("/{idClub}")
    public DefaultResponse<ClubDto> getByIdPlayer (@PathVariable Integer idClub){
        DefaultResponse response = clubService.readIdClub(idClub);
        return response;
    }

    @GetMapping
    public List<ClubDto> getPlayer(){
        List list = clubService.readAllClub();
        return list;
    }

    @DeleteMapping("/{id}")
    public DefaultResponse deleteById(@PathVariable("id") Integer id) {
        DefaultResponse response = clubService.deleteClub(id);
        return response;
    }
    @PutMapping
    public DefaultResponse<ClubDto> update(@RequestBody ClubDto clubDto) {
        DefaultResponse response = clubService.updateClub(clubDto);
        return response;
    }

}
