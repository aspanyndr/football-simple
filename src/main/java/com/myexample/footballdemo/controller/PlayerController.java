package com.myexample.footballdemo.controller;

// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.entity.Player;

@RestController
@RequestMapping("/player")
public class PlayerController {

    public Player convertDtoToEntity(PlayerDto playerDto) {
        Player player = new Player();

        player.setId(playerDto.getId());
        player.setPlayerName(playerDto.getPlayerName());
        player.setPlayerPosition(playerDto.getPlayerPosition());
        player.setCitizenship(playerDto.getCitizenship());
        player.setClubPlayer(playerDto.getClubPlayer());
    
        return player;
    }

    public PlayerDto convertEntityToDto(Player player) {
        PlayerDto playerDto = new PlayerDto();

        playerDto.setId(player.getId());
        playerDto.setPlayerName(player.getPlayerName());
        playerDto.setPlayerPosition(player.getPlayerPosition());
        playerDto.setClubPlayer(player.getClubPlayer());
        playerDto.setCitizenship(player.getCitizenship());
        
        return playerDto;
    }

}
