package com.myexample.footballdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.footballdemo.model.dto.ClubDto;
import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.entity.Club;
import com.myexample.footballdemo.repository.ClubRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;
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

    @PostMapping("/save")
    public DefaultResponse<ClubDto> saveClub(@RequestBody ClubDto clubDto){
        Club club = convertDtoToEntity(clubDto);
        DefaultResponse<ClubDto> response = new DefaultResponse<>();
        Optional <Club> optionalClubId = clubRepository.findByIdClub(clubDto.getIdClub());
        if(optionalClubId.isPresent()){
            response.setStatus(false);
            response.setMessege("Sorry, the player is already exist");
            response.setData(clubDto);
        }
        else if(optionalClubId.isEmpty()){
            clubRepository.save(club);
            response.setStatus(true);
            response.setMessege("Your data has been stored");
            response.setData(clubDto);
        }
        return response;
    }

    @GetMapping("/getById/{id}")
    public DefaultResponse<ClubDto> getByIdPlayer (@PathVariable Integer id){
        DefaultResponse<ClubDto> response = new DefaultResponse<>();
        Optional<Club> optionalClub = clubRepository.findByIdClub(id);
        if (optionalClub.isPresent()){
            response.setStatus(true);
            response.setMessege("Here's your club");
            response.setData(convertEntityToDto(optionalClub.get()));
        }
        else if( optionalClub.isEmpty()){
            response.setStatus(false);
            response.setMessege("Your club it's not found");
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
            response.setMessege("Succes deleted club");
            response.setData(optionalClub);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Failed delete club");
            response.setData(optionalClub);
        }
        return response;
    }

    @PutMapping("/update/{id}")
    public DefaultResponse update(@PathVariable("id") Integer id, @RequestBody ClubDto clubDto) {
        DefaultResponse df = new DefaultResponse();
        Optional<Club> optionaClub = clubRepository.findByIdClub(id);
        Club club = optionaClub.get();
        if (optionaClub.isPresent()) {
            club.setIdClub(clubDto.getIdClub());
            club.setClubName(clubDto.getClubName());
            club.setCompetition(clubDto.getCompetition());
            club.setIdCountry(clubDto.getIdCountry());

            
            clubRepository.save(club);
            df.setStatus(Boolean.TRUE);
            df.setMessege("Club succesfully updated");
            df.setData(club);
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessege("Sorry can not update club");
            df.setData(club);
        }
        return df;
    }

    public Club convertDtoToEntity(ClubDto clubDto){
        Club club = new Club();

        club.setIdClub(clubDto.getIdClub());
        club.setClubName(clubDto.getClubName());
        club.setCompetition(clubDto.getCompetition());

        return club;
    }

    public ClubDto convertEntityToDto(Club club){
        ClubDto clubDto = new ClubDto();

        clubDto.setIdClub(club.getIdClub());
        clubDto.setClubName(club.getClubName());
        clubDto.setCompetition(club.getCompetition());
        clubDto.setIdCountry(club.getIdClub());

        return clubDto;
    }    
}
