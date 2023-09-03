package com.myexample.footballdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myexample.footballdemo.service.ClubPlayerService;
import com.myexample.footballdemo.service.ClubService;
import com.myexample.footballdemo.service.serviceImpl.ClubPlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.footballdemo.model.dto.PlayerBioClubDto;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.entity.Player;
import com.myexample.footballdemo.repository.PlayerRepository;

@RestController
@RequestMapping("/football/clubPlayer")
public class ClubPlayerController {
    @Autowired
    ClubPlayerService clubPlayerService;


    @GetMapping
    public List getClubPlayerFull(){
        List list = clubPlayerService.readClubPlayerFull();
        return list;
    }

    @GetMapping("/{idPlayer}")
    public PlayerBioClubDto getPlayerBioClub (@PathVariable Integer idPlayer){
        PlayerBioClubDto bioClubDto = clubPlayerService.readClubPlayer(idPlayer);
        return bioClubDto;

    }


}



