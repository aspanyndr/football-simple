package com.myexample.footballdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myexample.footballdemo.model.dto.PlayerProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.service.PlayerService;

@RestController
@RequestMapping("/football/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @PostMapping
    public DefaultResponse<PlayerDto> savePlayer(@RequestBody PlayerDto playerDto){
        DefaultResponse response = playerService.createPlayer(playerDto);
        return response;
    }

    @GetMapping("/{idPlayer}")
    public DefaultResponse<PlayerDto> getByIdPlayer (@PathVariable("idPlayer") Integer idPlayer){
        DefaultResponse response = playerService.readIdPlayer(idPlayer);
        return response;
    }

    @GetMapping
    public List getPlayer(){
        List list = playerService.readAllPlayer();
        return list;
    }

    @DeleteMapping("/{idPlayer}")
    public DefaultResponse deleteById(@PathVariable("idPlayer") Integer idPlayer) {
        DefaultResponse response = playerService.deletePlayer(idPlayer);
        return response;
    }

     @PutMapping
     public DefaultResponse update( @RequestBody PlayerDto dto) {
        DefaultResponse response = playerService.updatePlayer(dto);
        return response;

     }

}
