package com.myexample.footballdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    PlayerRepository playerRepository;


    @GetMapping
    public List getClubPlayerFull(){
        List <PlayerBioClubDto> profileClubDtos = new ArrayList();
        for (Player player : playerRepository.findAll()){
            profileClubDtos.add(convertEntityToDtoPalyerClub(player));
        }
        return profileClubDtos;
    }

    @GetMapping("/{idPlayer}")
    public PlayerBioClubDto getPlayerBioClub (@PathVariable Integer idPlayer){
        PlayerBioClubDto bioClubDto = new PlayerBioClubDto();
        Optional<Player> optionalPlayer = playerRepository.findByIdPlayer(idPlayer);
        if (optionalPlayer.isPresent()){
            Player player = optionalPlayer.get();
            bioClubDto.setPlayerName(player.getPlayerName());
            bioClubDto.setAge(player.getAge());
            bioClubDto.setPosition(player.getPlayerPosition().getPosition());
            bioClubDto.setClubName(player.getPlayerClub().getClubName());
            bioClubDto.setCompetition(player.getPlayerClub().getCompetition());
        }else{

        }

        return bioClubDto;
    }

    public PlayerDto convertEntityToDto(Player en ) {
        PlayerDto dto = new PlayerDto();

        dto.setPlayerName(en.getPlayerName());
        dto.setAge(en.getAge());
        dto.setCountryName(en.getPlayerCountry().getCountryName());
        dto.setClubName(en.getPlayerClub().getClubName());
        dto.setCompetition(en.getPlayerClub().getCompetition());
        dto.setPosition(en.getPlayerPosition().getPosition());

        return dto;
    }

    public PlayerBioClubDto convertEntityToDtoPalyerClub(Player player) {
        PlayerBioClubDto dto = new PlayerBioClubDto();

        
        dto.setPlayerName(player.getPlayerName());
        dto.setAge(player.getAge());

        dto.setClubName(player.getPlayerClub().getClubName());
        dto.setCompetition(player.getPlayerClub().getCompetition());
        dto.setPosition(player.getPlayerPosition().getPosition());

        return dto;
    }

}

    

