package com.myexample.footballdemo.model.entity;

import javax.persistence.*;

@Entity
@Table(name ="t_club")
public class Club {

    @Id
    @Column(name="id_club")
    private Integer idClub;
    @Column
    private String clubName;
    @Column
    private String competition;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_country")
    private Country clubCountry;

    public Country getClubCountry() {
        return clubCountry;
    }

    public void setClubCountry(Country clubCountry) {
        this.clubCountry = clubCountry;
    }

    public Integer getIdClub() {
        return idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }
}
