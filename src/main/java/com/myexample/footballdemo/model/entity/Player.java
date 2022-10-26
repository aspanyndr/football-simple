package com.myexample.footballdemo.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

    @Column(name="id_position")
    private Integer idPosition;
    @Column(name="id_country")
    private Integer idCountry;
    @Column(name="id_club")
    private Integer idClub;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_position",insertable = false, updatable = false)
    private Position playerPosition;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_country", insertable = false, updatable = false)
    private Country playerCountry;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_club", insertable = false, updatable = false)
    private Club playerClub;


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

    public Position getPlayerPosition() {
        return this.playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Country getPlayerCountry() {
        return this.playerCountry;
    }

    public void setPlayerCountry(Country playerCountry) {
        this.playerCountry = playerCountry;
    }

    public Club getPlayerClub() {
        return this.playerClub;
    }

    public void setPlayerClub(Club playerClub) {
        this.playerClub = playerClub;
    }

}
