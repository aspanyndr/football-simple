package com.myexample.footballdemo.model.dto;

public class PlayerDto {
    
    private Integer id;
    private String playerName;
    private String playerPosition;
    private String citizenship;
    private String clubPlayer;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPosition() {
        return this.playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getCitizenship() {
        return this.citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getClubPlayer() {
        return this.clubPlayer;
    }

    public void setClubPlayer(String clubPlayer) {
        this.clubPlayer = clubPlayer;
    }

}
