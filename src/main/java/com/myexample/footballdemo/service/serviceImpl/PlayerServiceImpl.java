package com.myexample.footballdemo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.dto.PlayerProfileDto;
import com.myexample.footballdemo.model.entity.Club;
import com.myexample.footballdemo.model.entity.Country;
import com.myexample.footballdemo.model.entity.Player;
import com.myexample.footballdemo.model.entity.PosPlayer;
import com.myexample.footballdemo.repository.ClubRepository;
import com.myexample.footballdemo.repository.CountryRepository;
import com.myexample.footballdemo.repository.PlayerRepository;
import com.myexample.footballdemo.repository.PositionRepository;
import com.myexample.footballdemo.service.PlayerService;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ClubRepository clubRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    PositionRepository positionRepository;

    @Override
    public DefaultResponse createPlayer(PlayerDto playerDto) {
        Player player = convertDtoToEntity(playerDto);
        DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        Optional <Player> optionalPlayer = playerRepository.findByIdPlayer(playerDto.getIdPlayer());
        if(optionalPlayer.isPresent()){
            response.setStatus(false);
            response.setMessege("Sorry, the player is already exist");
        }
        else {
            response.setData(convertEntityToDto(playerRepository.save(player)));
            response.setStatus(true);
            response.setMessege("Your data has been stored");
        }
        return response;
    }

    @Override
    public DefaultResponse deletePlayer(Integer idPlayer) {
        DefaultResponse response = new DefaultResponse();
        Optional<Player> optionalPlayer = playerRepository.findByIdPlayer(idPlayer);
        if (optionalPlayer.isPresent()){
            playerRepository.delete(optionalPlayer.get());
            response.setStatus(Boolean.TRUE);
            response.setMessege("Success delete player");
            response.setData(optionalPlayer);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Failed delete player");
            response.setData(optionalPlayer);
        }
        return response;
    }

    @Override
    public List readAllPlayer() {
        List <PlayerDto> playersDtos = new ArrayList();
        for (Player player : playerRepository.findAll()){
            playersDtos.add(convertEntityToDto(player));
        }
        return playersDtos;
    }

    @Override
    public DefaultResponse readIdPlayer(Integer idPlayer) {
        DefaultResponse<PlayerDto> response = new DefaultResponse<>();
        Optional<Player> optionalPlayer = playerRepository.findByIdPlayer(idPlayer);
        // PlayerDto player = new PlayerDto();
        if (optionalPlayer.isPresent()){
            response.setStatus(true);
            response.setMessege("Found it!, Here's your player");
            response.setData(convertEntityToDto(optionalPlayer.get()));
            
        }
        else{
            response.setStatus(false);
            response.setMessege("Your player it's not found");
        }        
        return response;
    }

    @Override
    public DefaultResponse updatePlayer(PlayerDto dto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Player> optionaPlayer = playerRepository.findById(dto.getIdPlayer());
        Player player = optionaPlayer.get();
        if (optionaPlayer.isPresent()) {
            df.setData(convertEntityToDto(playerRepository.save(convertDtoToEntity(dto))));
            df.setStatus(Boolean.TRUE);
            df.setMessege("Player successfully updated");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessege("Sorry cannot update player");
        }
        return df;
    }

    public Player convertDtoToEntity(PlayerDto dto) {
        Player ent = new Player();

        ent.setIdPlayer(dto.getIdPlayer());
        ent.setPlayerName(dto.getPlayerName());
        ent.setAge(dto.getAge());

        Club club = clubRepository.findByIdClub(dto.getIdClub()).get();
        ent.setPlayerClub(club);

        Country country = countryRepository.findByIdCountry(dto.getIdCountry()).get();
        ent.setPlayerCountry(country);

        PosPlayer posPlayer = positionRepository.findByIdPosition(dto.getIdPosition()).get();
        ent.setPlayerPosition(posPlayer);

        return ent;
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

        dto.setPosition(player.getPlayerPosition().getPosition());

        return dto;
    }
    
}
