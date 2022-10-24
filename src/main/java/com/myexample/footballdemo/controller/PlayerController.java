package com.myexample.footballdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.entity.Player;
import com.myexample.footballdemo.repository.PlayerRepository;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @PostMapping("/save")
    public DefaultResponse<PlayerDto> savePlayer(@RequestBody PlayerDto playerDto){
        Player player = convertDtoToEntity(playerDto);
        DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        Optional <Player> optionalPlayer = playerRepository.findById(playerDto.getId());
        if(optionalPlayer.isPresent()){
            response.setStatus(false);
            response.setMessege("Sorry, the player is already exist");
            response.setData(playerDto);
        }
        else if(optionalPlayer.isEmpty()){
            playerRepository.save(player);
            response.setStatus(true);
            response.setMessege("Your data has been stored");
            response.setData(playerDto);
        }
        return response;
    }

    @GetMapping("/getById/{id}")
    public DefaultResponse<PlayerDto> getByIdPlayer (@PathVariable Integer id){
        DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()){
            response.setStatus(true);
            response.setMessege("Here's your player");
            // response.setData(response.getData());
            response.setData(convertEntityToDto(optionalPlayer.get()));
        }
        else if( optionalPlayer.isEmpty()){
            response.setStatus(false);
            response.setMessege("Your player it's not found");
        }        
        return response;
    }

    @GetMapping("/get")
    public List<PlayerDto> getPlayer(){
        List <PlayerDto> playersDtos = new ArrayList<PlayerDto>();
        for (Player player : playerRepository.findAll()){
            playersDtos.add(convertEntityToDto(player));
        }
        return playersDtos;
    }

    @DeleteMapping("/delete/{id}")
    public DefaultResponse deleteById(@PathVariable("id") Integer id) {
        DefaultResponse response = new DefaultResponse();
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()){
            playerRepository.delete(optionalPlayer.get());
            response.setStatus(Boolean.TRUE);
            response.setMessege("Succes delete player");
            response.setData(optionalPlayer);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Failed delete player");
            response.setData(optionalPlayer);
        }
        return response;
    }

    @PutMapping("/update/{id}")
    public DefaultResponse update(@PathVariable("id") Integer id, @RequestBody PlayerDto playerDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Player> optionaPlayer = playerRepository.findById(id);
        Player player = optionaPlayer.get();
        if (optionaPlayer.isPresent()) {
            player.setId(playerDto.getId());
            player.setPlayerName(playerDto.getPlayerName());
            player.setPlayerPosition(playerDto.getPlayerPosition());
            player.setClubPlayer(playerDto.getClubPlayer());
            player.setCitizenship(playerDto.getCitizenship());
            
            playerRepository.save(player);
            df.setStatus(Boolean.TRUE);
            df.setMessege("Player succesfully updated");
            df.setData(player);
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessege("Can't update player");
            df.setData(player);
        }
        return df;
    }
    

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
