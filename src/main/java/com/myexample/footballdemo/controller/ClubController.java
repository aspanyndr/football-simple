package com.myexample.footballdemo.controller;

import com.myexample.footballdemo.model.entity.Country;
import com.myexample.footballdemo.repository.CountryRepository;
import com.myexample.footballdemo.repository.PlayerRepository;
import com.myexample.footballdemo.repository.PositionRepository;
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
@RequestMapping("/club")
public class ClubController {

    @Autowired
    ClubRepository clubRepository;
    @Autowired
    CountryRepository countryRepository;

    @PostMapping("/save")
    public DefaultResponse<ClubDto> saveClub(@RequestBody ClubDto clubDto){
        Club club = convertDtoToEntity(clubDto);
        DefaultResponse<ClubDto> response = new DefaultResponse<>();
        Optional <Club> optionalClubId = clubRepository.findByIdClub(clubDto.getIdClub());
        if(optionalClubId.isPresent()){
            response.setStatus(false);
            response.setMessege("Sorry, club is already exist");
            response.setData(clubDto);
        }
        else if(optionalClubId.isEmpty()){
            response.setData(convertEntityToDto(clubRepository.save(club)));
            response.setStatus(true);
            response.setMessege("Thanks!, Your data has been stored");
            response.setData(clubDto);
        }
        return response;
    }

    @GetMapping("/get/{idClub}")
    public DefaultResponse<ClubDto> getByIdPlayer (@PathVariable Integer idClub){
        DefaultResponse<ClubDto> response = new DefaultResponse<>();
        Optional<Club> optionalClub = clubRepository.findByIdClub(idClub);
        if (optionalClub.isPresent()){
            response.setStatus(true);
            response.setMessege("Success!, Here's your club");
            response.setData(convertEntityToDto(optionalClub.get()));
        }
        else if( optionalClub.isEmpty()){
            response.setStatus(false);
            response.setMessege("Sorry, your club it's not found");
        }        
        return response;
    }

    @GetMapping("/get")
    public List<ClubDto> getPlayer(){
        List <ClubDto> listClub = new ArrayList<ClubDto>();
        for (Club club : clubRepository.findAll()){
            listClub.add(convertEntityToDto(club));
        }
        return listClub;
    }

    @DeleteMapping("/delete/{id}")
    public DefaultResponse deleteById(@PathVariable("id") Integer id) {
        DefaultResponse response = new DefaultResponse();
        Optional<Club> optionalClub = clubRepository.findByIdClub(id);
        if (optionalClub.isPresent()){
            clubRepository.delete(optionalClub.get());
            response.setStatus(Boolean.TRUE);
            response.setMessege("Success!, deleted your picked club");
            response.setData(optionalClub);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Sorry, club that you choose cannot be found");
            response.setData(optionalClub);
        }
        return response;
    }

    @PutMapping("/update")
    public DefaultResponse<ClubDto> update(@RequestBody ClubDto clubDto) {
        DefaultResponse response = new DefaultResponse();
        Optional<Club> optionalClub = clubRepository.findByIdClub(clubDto.getIdClub());
        Club club = optionalClub.get();
        if (optionalClub.isPresent()) {


            response.setData(convertEntityToDto(clubRepository.save(convertDtoToEntity(clubDto))));
            response.setStatus(Boolean.TRUE);
            response.setMessege("Success!, your club successfully updated");

        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Sorry, theres a mistake can not update club");
            response.setData(club);
        }
        return response;
    }

    public Club convertDtoToEntity(ClubDto clubDto){
        Club club = new Club();

        club.setIdClub(clubDto.getIdClub());
        club.setClubName(clubDto.getClubName());
        club.setCompetition(clubDto.getCompetition());

        Country country = countryRepository.findByIdCountry(clubDto.getIdCountry()).get();
        club.setClubCountry(country);


        return club;
    }

    public ClubDto convertEntityToDto(Club ent){
        ClubDto dto = new ClubDto();

        dto.setIdClub(ent.getIdClub());
        dto.setClubName(ent.getClubName());
        dto.setCompetition(ent.getCompetition());

        dto.setIdCountry(ent.getClubCountry().getIdCountry());
        dto.setClubOrigin(ent.getClubCountry().getCountryName());

        return dto;
    }    
}
