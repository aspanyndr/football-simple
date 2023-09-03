package com.myexample.footballdemo.service.serviceImpl;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerBioClubDto;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.dto.PlayerProfileDto;
import com.myexample.footballdemo.model.entity.Player;
import com.myexample.footballdemo.repository.PlayerRepository;
import com.myexample.footballdemo.service.ClubPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClubPlayerServiceImpl implements ClubPlayerService {

    private final PlayerRepository playerRepository;

    public ClubPlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }


    @Override
    public List readClubPlayerFull() {
        List <PlayerBioClubDto> profileClubDtos = new ArrayList();
        for (Player player : playerRepository.findAll()){
            profileClubDtos.add(convertEntityToDtoPalyerClub(player));
        }
        return profileClubDtos;
    }

    @Override
    public PlayerBioClubDto readClubPlayer(Integer idPlayer) {
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

//    @Override
//    public DefaultResponse readClubPlayer(Integer idPlayer) {
//        DefaultResponse response =
//    }

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
