package com.myexample.footballdemo.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_player")
public class Player {

    @Id
    @Column(name = "id_player")
    private Integer idPlayer;
    @Column(name="player_name")
    private String playerName;
    @Column(name="age")
    private Integer age;
//    @Column(name="id_position")
//    private Integer idPosition;
//    @Column(name="id_country")
//    private Integer idCountry;
//    @Column(name="id_club")
//    private Integer idClub;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_position")
    private PosPlayer playerPosPlayer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_country")
    private Country playerCountry;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_club")
    private Club playerClub;

    public Integer getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Integer idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PosPlayer getPlayerPosition() {
        return playerPosPlayer;
    }

    public void setPlayerPosition(PosPlayer playerPosPlayer) {
        this.playerPosPlayer = playerPosPlayer;
    }

    public Country getPlayerCountry() {
        return playerCountry;
    }

    public void setPlayerCountry(Country playerCountry) {
        this.playerCountry = playerCountry;
    }

    public Club getPlayerClub() {
        return playerClub;
    }

    public void setPlayerClub(Club playerClub) {
        this.playerClub = playerClub;
    }
}
