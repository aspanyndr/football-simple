package com.myexample.footballdemo.model.dto;

public class PlayerDto {
    
    private Integer idPlayer;
    private String playerName;
    private Integer age;
    private Integer idPosition;
    private Integer idClub;
    private Integer idCountry;


    public Integer getIdPlayer() {
        return this.idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIdPosition() {
        return this.idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }

    public Integer getIdClub() {
        return this.idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public Integer getIdCountry() {
        return this.idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

}
