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
import com.myexample.footballdemo.model.entity.Club;
import com.myexample.footballdemo.model.entity.Country;
import com.myexample.footballdemo.model.entity.Player;
import com.myexample.footballdemo.model.entity.Position;
import com.myexample.footballdemo.repository.ClubRepository;
import com.myexample.footballdemo.repository.CountryRepository;
import com.myexample.footballdemo.repository.PlayerRepository;
import com.myexample.footballdemo.repository.PositionRepository;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PositionRepository positionRepository;


    @PostMapping("/save")
    public DefaultResponse<PlayerDto> savePlayer(@RequestBody PlayerDto playerDto){
        Player player = convertDtoToEntity(playerDto);
        DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        Optional <Player> optionalPlayer = playerRepository.findByIdPlayer(playerDto.getIdPlayer());
        List <Player> optionalPlayer2 = playerRepository.findAll();
        if(optionalPlayer.isPresent()){
            response.setStatus(false);
            response.setMessege("Sorry, the player is already exist");
            response.setData(playerDto);
             response.setData(convertEntityToDto(playerRepository.save(player)));
        }
        else {
            playerRepository.save(player);
            response.setStatus(true);
            response.setMessege("Your data has been stored");
            // response.setData(playerDto);
        }
        return response;
    }

    @GetMapping("/{idPlayer}")
    public DefaultResponse<PlayerDto> getByIdPlayer (@PathVariable("idPlayer")  Integer idPlayer){
        DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        Optional<Player> optionalPlayer = playerRepository.findByIdPlayer(idPlayer);
        PlayerDto player = new PlayerDto();
        if (optionalPlayer.isPresent()){
            response.setStatus(true);
            response.setMessege("Here's your player");
            // response.setData(player);
            response.setData(convertEntityToDto(optionalPlayer.get()));
            
        }
        else{
            response.setStatus(false);
            response.setMessege("Your player it's not found");
        }        
        return response;
    }

    @GetMapping("/get")
    public List getPlayer(){
        List <PlayerDto> playersDtos = new ArrayList();
        for (Player player : playerRepository.findAll()){
            playersDtos.add(convertEntityToDto(player));
        }
        return playersDtos;
    }

    @DeleteMapping("/delete/{idPlayer}")
    public DefaultResponse deleteById(@PathVariable("idPlayer") Integer idPlayer) {
        DefaultResponse response = new DefaultResponse();
        Optional<Player> optionalPlayer = playerRepository.findByIdPlayer(idPlayer);
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
             playerDto.setIdPlayer(player.getIdPlayer());
             playerDto.setAge(player.getAge());
             playerDto.setPlayerName(player.getPlayerName());
             playerDto.setIdClub(player.getPlayerClub().getIdClub());
             playerDto.setIdCountry(player.getPlayerCountry().getIdCountry());
             playerDto.setIdPosition(playerDto.getIdPosition());

             playerRepository.save(player);
             df.setStatus(Boolean.TRUE);
             df.setMessege("Player succesfully updated");
         } else {
             df.setStatus(Boolean.FALSE);
             df.setMessege("Sorry can not update player");
         }
         return df;
     }
    

    public Player convertDtoToEntity(PlayerDto playerDto) {
        Player player = new Player();

        player.setIdPlayer(playerDto.getIdPlayer());
        player.setPlayerName(playerDto.getPlayerName());
        player.setAge(playerDto.getAge());

        // player.setIdClub(playerDto.getIdClub());
        // player.setPlayerClub(playerDto.getIdClub());
        // player.setIdPosition(playerDto.getIdPosition());


        return player;
    }

    public PlayerDto convertEntityToDto(Player player ) {
        PlayerDto playerDto = new PlayerDto();

        playerDto.setIdPlayer(player.getIdPlayer());
        playerDto.setPlayerName(player.getPlayerName());
        playerDto.setAge(player.getAge());
        playerDto.setIdClub(player.getPlayerClub().getIdClub());
        playerDto.setIdCountry(player.getPlayerCountry().getIdCountry());
        playerDto.setIdPosition(player.getPlayerPosition().getIdPosition());

        return playerDto;
    }

}
