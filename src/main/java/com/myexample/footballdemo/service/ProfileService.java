package com.myexample.footballdemo.service;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerProfileDto;

import java.util.List;

public interface ProfileService {

    List getPlayerProfiles();

    DefaultResponse readByIdPlayer(Integer id);
}
