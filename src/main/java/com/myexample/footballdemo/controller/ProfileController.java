package com.myexample.footballdemo.controller;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.dto.PlayerProfileDto;
import com.myexample.footballdemo.model.entity.Player;
import com.myexample.footballdemo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    PlayerRepository playerRepository;


    @GetMapping("/get")
    public List getPlayerFull(){
        List <PlayerProfileDto> profileDtos = new ArrayList();
        for (Player player : playerRepository.findAll()){
            profileDtos.add(convertEntityToDtoFull(player));
        }
        return profileDtos;
    }

    @GetMapping("get/{idPosition}")
    public DefaultResponse<PlayerProfileDto> getByIdPlayer (@PathVariable("idPosition") Integer id){
        DefaultResponse<PlayerProfileDto> response = new DefaultResponse<>();
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        PlayerProfileDto player = new PlayerProfileDto();
        if (optionalPlayer.isPresent()){
            response.setStatus(true);
            response.setMessege("Found it!, Here's your player profile");
            // response.setData(player);
            response.setData(convertEntityToDtoFull(optionalPlayer.get()));
        }
        else{
            response.setStatus(false);
            response.setMessege("Sorry theres a mistake, your player cannot be found");
        }
        return response;
    }

    public PlayerDto convertEntityToDto(Player en ) {
        PlayerDto dto = new PlayerDto();

        dto.setIdPlayer(en.getIdPlayer());
        dto.setPlayerName(en.getPlayerName());
        dto.setAge(en.getAge());

        dto.setIdCountry(en.getPlayerCountry().getIdCountry());
        dto.setCountryName(en.getPlayerCountry().getCountryName());
        dto.setFifaRank(en.getPlayerCountry().getFifaRank());

        dto.setIdClub(en.getPlayerClub().getIdClub());
        dto.setClubName(en.getPlayerClub().getClubName());
        dto.setCompetition(en.getPlayerClub().getCompetition());

        dto.setIdPosition(en.getPlayerPosition().getIdPosition());
        dto.setPosition(en.getPlayerPosition().getPosition());

        return dto;
    }

    public PlayerProfileDto convertEntityToDtoFull(Player player) {
        PlayerProfileDto dto = new PlayerProfileDto();

        dto.setIdPlayer(player.getIdPlayer());
        dto.setPlayerName(player.getPlayerName());
        dto.setAge(player.getAge());

        dto.setClubName(player.getPlayerClub().getClubName());
        dto.setClubCompetition(player.getPlayerClub().getCompetition());
        dto.setClubCountry(player.getPlayerClub().getClubCountry().getCountryName());

        dto.setCountryPlayer(player.getPlayerCountry().getCountryName());
        dto.setCountryRank(player.getPlayerCountry().getFifaRank());

        dto.setPosition(player.getPlayerPosition().getPosition());

        return dto;
    }

}
