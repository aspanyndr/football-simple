package com.myexample.footballdemo.service;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerBioClubDto;

import java.util.List;

public interface ClubPlayerService {

    List readClubPlayerFull();
    PlayerBioClubDto readClubPlayer(Integer idPlayer);
}
