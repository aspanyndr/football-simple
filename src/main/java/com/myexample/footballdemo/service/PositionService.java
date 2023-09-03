package com.myexample.footballdemo.service;

import com.myexample.footballdemo.model.dto.DefaultResponse;
import com.myexample.footballdemo.model.dto.PlayerDto;
import com.myexample.footballdemo.model.dto.PosDto;

import javax.swing.*;
import java.util.List;


public interface PositionService {

    DefaultResponse createPosition(PosDto posDto);

    DefaultResponse readIdPlayer(Integer idPosition);

    List readAllPosition();

    DefaultResponse deletePosition(Integer idPosition);
    DefaultResponse updatePosition(PosDto posDto);


}
