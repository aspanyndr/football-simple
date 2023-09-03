package com.myexample.footballdemo.service.serviceImpl;

import com.myexample.footballdemo.model.dto.ClubDto;
import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.entity.Club;
import com.myexample.footballdemo.model.entity.Country;
import com.myexample.footballdemo.repository.ClubRepository;
import com.myexample.footballdemo.repository.CountryRepository;
import com.myexample.footballdemo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ClubServiceImpl implements ClubService {

    @Autowired
    ClubRepository clubRepository;
    @Autowired
    CountryRepository countryRepository;
    @Override
    public DefaultResponse createClub(ClubDto clubDto) {
        Club club = convertDtoToEntity(clubDto);
        DefaultResponse<ClubDto> response = new DefaultResponse<>();
        Optional<Club> optionalClubId = clubRepository.findByIdClub(clubDto.getIdClub());
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

    @Override
    public DefaultResponse readIdClub(Integer idClub) {
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

    @Override
    public List readAllClub() {
        List <ClubDto> listClub = new ArrayList<ClubDto>();
        for (Club club : clubRepository.findAll()){
            listClub.add(convertEntityToDto(club));
        }
        return listClub;
    }

    @Override
    public DefaultResponse deleteClub(Integer idClub) {
        DefaultResponse response = new DefaultResponse();
        Optional<Club> optionalClub = clubRepository.findByIdClub(idClub);
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

    @Override
    public DefaultResponse updateClub(ClubDto clubDto) {
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
