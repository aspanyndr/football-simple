package com.myexample.footballdemo.service.serviceImpl;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.dto.PosDto;
import com.myexample.footballdemo.model.entity.PosPlayer;
import com.myexample.footballdemo.repository.PositionRepository;
import com.myexample.footballdemo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionRepository positionRepository;
    @Override
    public DefaultResponse createPosition(PosDto posDto) {
        PosPlayer posPlayer = entityToDto(posDto);
        DefaultResponse<PosDto> response = new DefaultResponse<>();
        Optional<PosPlayer> optionalPosition = positionRepository.findByIdPosition(posDto.getIdPosition());
        if (optionalPosition.isPresent()) {
            response.setStatus(false);
            response.setMessege("Sorry, the position is already exist");
        }
        else {
            response.setData(dtoToEntity(positionRepository.save(posPlayer)));
            response.setStatus(true);
            response.setMessege("Success, your data has been stored");
        }
        return response;
    }


    @Override
    public DefaultResponse readIdPlayer(Integer idPosition) {
        DefaultResponse<PosDto> response = new DefaultResponse<>();
        Optional<PosPlayer> optionalPosPlayer = positionRepository.findByIdPosition(idPosition);
        PlayerDto player = new PlayerDto();
        if (optionalPosPlayer.isPresent()){
            response.setStatus(true);
            response.setMessege("Found it!, This is your position");
            response.setData(dtoToEntity(optionalPosPlayer.get()));
        }
        else{
            response.setStatus(false);
            response.setMessege("Sorry, the position not available");
        }
        return response;
    }

    @Override
    public List readAllPosition() {
        List <PosDto> posDtos = new ArrayList();
        for (PosPlayer posPlayer : positionRepository.findAll()){
            posDtos.add(dtoToEntity(posPlayer));
        }
        return posDtos;
    }

    @Override
    public DefaultResponse deletePosition(Integer idPosition) {
        DefaultResponse response = new DefaultResponse();
        Optional<PosPlayer> optionalPosPlayer = positionRepository.findByIdPosition(idPosition);
        if (optionalPosPlayer.isPresent()){
            positionRepository.delete(optionalPosPlayer.get());
            response.setStatus(Boolean.TRUE);
            response.setMessege("Success delete position");
            response.setData(optionalPosPlayer);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Sorry, position not found");
            response.setData(optionalPosPlayer);
        }
        return response;
    }

    @Override
    public DefaultResponse updatePosition(PosDto posDto) {
        DefaultResponse response = new DefaultResponse();
        Optional<PosPlayer> optionalPosPlayer = positionRepository.findByIdPosition(posDto.getIdPosition());
        PosPlayer posPlayer = optionalPosPlayer.get();
        if (optionalPosPlayer.isPresent()) {

            posPlayer.setIdPosition(posDto.getIdPosition());
            posPlayer.setPosition(posDto.getPosition());

            positionRepository.save(posPlayer);
            response.setStatus(Boolean.TRUE);
            response.setMessege("Player successfully updated");
            response.setData(posPlayer);
        } else {
            response.setStatus(Boolean.FALSE);
            response.setMessege("Sorry can not update player");
        }
        return response;
    }


    public PosPlayer entityToDto(PosDto dto){
        PosPlayer ent = new PosPlayer();

        ent.setIdPosition(dto.getIdPosition());
        ent.setPosition(dto.getPosition());

        return ent;
    }

    public PosDto dtoToEntity(PosPlayer entity) {
        PosDto dto = new PosDto();

        dto.setIdPosition(entity.getIdPosition());
        dto.setPosition(entity.getPosition());

        return dto;

    }
}
