package com.myexample.footballdemo.controller;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.dto.PosDto;
import com.myexample.footballdemo.model.entity.PosPlayer;
import com.myexample.footballdemo.repository.PositionRepository;
import com.myexample.footballdemo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football/pos")
public class PositionController {

    @Autowired
    PositionService positionService;

    @PostMapping
    public DefaultResponse<PosDto> savePos(@RequestBody PosDto dto) {
        DefaultResponse response = positionService.createPosition(dto);
        return response;
    }


    @GetMapping("/{idPosition}")
    public DefaultResponse<PosDto> getByIdPlayer (@PathVariable("idPosition") Integer idPosition){
        DefaultResponse response = positionService.readIdPlayer(idPosition);
        return response;
    }

    @GetMapping
    public List getPosition(){
        List list = positionService.readAllPosition();
        return  list;
    }

    @DeleteMapping("/{idPosition}")
    public DefaultResponse deleteById(@PathVariable("idPosition") Integer idPosition) {
        DefaultResponse response = positionService.deletePosition(idPosition);
        return response;
    }

    @PutMapping
    public DefaultResponse updatePosition( @RequestBody PosDto dto) {
        DefaultResponse response = positionService.updatePosition(dto);
        return response;
    }

}
