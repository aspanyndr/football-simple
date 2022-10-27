package com.myexample.footballdemo.service;

import java.util.List;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;

public interface PlayerService {

    DefaultResponse createPlayer(PlayerDto playerDto);
    DefaultResponse readIdPlayer(Integer idPlayer);
    List readAllPlayer();
    DefaultResponse deletePlayer(Integer idPlayer);
    DefaultResponse updatePlayer(PlayerDto dto);

    

    
}
