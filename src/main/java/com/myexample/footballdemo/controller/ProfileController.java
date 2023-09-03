package com.myexample.footballdemo.controller;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerBioClubDto;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.dto.PlayerProfileDto;
import com.myexample.footballdemo.model.entity.Player;
import com.myexample.footballdemo.repository.PlayerRepository;
import com.myexample.footballdemo.service.PlayerService;
import com.myexample.footballdemo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @GetMapping
    public List getPlayerFull(){
        List list = profileService.getPlayerProfiles();
        return list;


    }

    @GetMapping("/{idPlayer}")
    public DefaultResponse<PlayerProfileDto> getByIdPlayer (@PathVariable("idPlayer") Integer id){
        DefaultResponse response = profileService.readByIdPlayer(id);
        return response;
    }
}
