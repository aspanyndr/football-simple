package com.myexample.footballdemo.model.dto;


public class ClubDto {

    private Integer idClub;
    private String clubName;
    private String competition;
    private Integer idCountry;


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

    public Integer getIdCountry() {
        return this.idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

}
