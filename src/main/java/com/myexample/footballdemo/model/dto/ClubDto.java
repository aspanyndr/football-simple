package com.myexample.footballdemo.model.dto;


public class ClubDto {

    private Integer idClub;
    private String clubName;
    private String competition;
    private Integer idCountry;
    private String clubOrigin;


    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

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

    public String getClubOrigin() {
        return clubOrigin;
    }

    public void setClubOrigin(String clubOrigin) {
        this.clubOrigin = clubOrigin;
    }
}
