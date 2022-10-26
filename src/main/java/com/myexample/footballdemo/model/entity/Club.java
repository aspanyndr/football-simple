package com.myexample.footballdemo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @Column(name="id_country")
    private Integer idCountry;

    public Integer getIdCountry() {
        return this.idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }


    
    // @OneToOne
    // @JoinColumn(name="id_country", insertable = false, updatable = false)
    // private Country clubCountry;

    public Integer getIdClub() {
        return this.idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getClubName() {
        return this.clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCompetition() {
        return this.competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }


    
}
