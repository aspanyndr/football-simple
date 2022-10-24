package com.myexample.footballdemo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {

    @Id
    @Column(name = "player_id", length  = 5)
    private Integer id;
    @Column(name = "player_name")
    private String playerName;
    @Column(name = "player_position")
    private String playerPosition;
    @Column(name = "citizenship")
    private String citizenship;
    @Column(name = "club_player")
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
