package com.myexample.footballdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myexample.footballdemo.model.dto.PlayerProfileDto;
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
import com.myexample.footballdemo.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    // @Autowired
    // ClubRepository clubRepository;

    // @Autowired
    // CountryRepository countryRepository;

    // @Autowired
    // PositionRepository positionRepository;


    @PostMapping("/save")
    public DefaultResponse<PlayerDto> savePlayer(@RequestBody PlayerDto playerDto){
        // Player player = convertDtoToEntity(playerDto);
        // DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        // Optional <Player> optionalPlayer = playerRepository.findByIdPlayer(playerDto.getIdPlayer());
        // if(optionalPlayer.isPresent()){
        //     response.setStatus(false);
        //     response.setMessege("Sorry, the player is already exist");
        // }
        // else {
        //     response.setData(convertEntityToDto(playerRepository.save(player)));
        //     response.setStatus(true);
        //     response.setMessege("Your data has been stored");
        // }
        DefaultResponse response = playerService.createPlayer(playerDto);
        return response;
    }

    @GetMapping("/get/{idPlayer}")
    public DefaultResponse<PlayerDto> getByIdPlayer (@PathVariable("idPlayer") Integer idPlayer){
        // DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        // Optional<Player> optionalPlayer = playerRepository.findByIdPlayer(idPlayer);
        // PlayerDto player = new PlayerDto();
        // if (optionalPlayer.isPresent()){
        //     response.setStatus(true);
        //     response.setMessege("Found it!, Here's your player");
        //     response.setData(convertEntityToDto(optionalPlayer.get()));
            
        // }
        // else{
        //     response.setStatus(false);
        //     response.setMessege("Your player it's not found");
        // }        
        // return response;
        DefaultResponse response = playerService.readIdPlayer(idPlayer);
        return response;
    }

    @GetMapping("/get")
    public List getPlayer(){
        List list = playerService.readAllPlayer();
        // List <PlayerDto> playersDtos = new ArrayList();
        // for (Player player : playerRepository.findAll()){
        //     playersDtos.add(convertEntityToDto(player));
        // }
        // return playersDtos;
        return list;
    }

    @DeleteMapping("/delete/{idPlayer}")
    public DefaultResponse deleteById(@PathVariable("idPlayer") Integer idPlayer) {
        // DefaultResponse response = new DefaultResponse();
        // Optional<Player> optionalPlayer = playerRepository.findByIdPlayer(idPlayer);
        // if (optionalPlayer.isPresent()){
        //     playerRepository.delete(optionalPlayer.get());
        //     response.setStatus(Boolean.TRUE);
        //     response.setMessege("Success delete player");
        //     response.setData(optionalPlayer);
        // } else {
        //     response.setStatus(Boolean.FALSE);
        //     response.setMessege("Failed delete player");
        //     response.setData(optionalPlayer);
        // }
        // return response;
        DefaultResponse response = playerService.deletePlayer(idPlayer);
        return response;
    }

     @PutMapping("/update")
     public DefaultResponse update( @RequestBody PlayerDto dto) {
        //  DefaultResponse df = new DefaultResponse();
        //  Optional<Player> optionaPlayer = playerRepository.findById(dto.getIdPlayer());
        //  Player player = optionaPlayer.get();
        //  if (optionaPlayer.isPresent()) {

        //      df.setData(convertEntityToDto(playerRepository.save(convertDtoToEntity(dto))));
        //      df.setStatus(Boolean.TRUE);
        //      df.setMessege("Player successfully updated");
        //  } else {
        //      df.setStatus(Boolean.FALSE);
        //      df.setMessege("Sorry cannot update player");
        //  }
        //  return df;
        DefaultResponse response = playerService.updatePlayer(dto);
        return response;

     }
    

    // public Player convertDtoToEntity(PlayerDto dto) {
    //     Player ent = new Player();

    //     ent.setIdPlayer(dto.getIdPlayer());
    //     ent.setPlayerName(dto.getPlayerName());
    //     ent.setAge(dto.getAge());

    //     Club club = clubRepository.findByIdClub(dto.getIdClub()).get();
    //     ent.setPlayerClub(club);

    //     Country country = countryRepository.findByIdCountry(dto.getIdCountry()).get();
    //     ent.setPlayerCountry(country);

    //     PosPlayer posPlayer = positionRepository.findByIdPosition(dto.getIdPosition()).get();
    //     ent.setPlayerPosition(posPlayer);

    //     return ent;
    // }

    // public PlayerDto convertEntityToDto(Player en ) {
    //     PlayerDto dto = new PlayerDto();

    //     dto.setIdPlayer(en.getIdPlayer());
    //     dto.setPlayerName(en.getPlayerName());
    //     dto.setAge(en.getAge());

    //     dto.setIdCountry(en.getPlayerCountry().getIdCountry());
    //     dto.setCountryName(en.getPlayerCountry().getCountryName());
    //     dto.setFifaRank(en.getPlayerCountry().getFifaRank());

    //     dto.setIdClub(en.getPlayerClub().getIdClub());
    //     dto.setClubName(en.getPlayerClub().getClubName());
    //     dto.setCompetition(en.getPlayerClub().getCompetition());

    //     dto.setIdPosition(en.getPlayerPosition().getIdPosition());
    //     dto.setPosition(en.getPlayerPosition().getPosition());

    //     return dto;
    // }

    // public PlayerProfileDto convertEntityToDtoFull(Player player) {
    //     PlayerProfileDto dto = new PlayerProfileDto();

    //     dto.setIdPlayer(player.getIdPlayer());
    //     dto.setPlayerName(player.getPlayerName());
    //     dto.setAge(player.getAge());

    //     dto.setClubName(player.getPlayerClub().getClubName());
    //     dto.setClubCompetition(player.getPlayerClub().getCompetition());
    //     dto.setClubCountry(player.getPlayerClub().getClubCountry().getCountryName());

    //     dto.setPosition(player.getPlayerPosition().getPosition());

    //     return dto;
    // }
}
