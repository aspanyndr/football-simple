package com.myexample.footballdemo.model.dto;

public class CountryDto {

    private Integer idCountry;
    private String countryName;
    private Integer fifaRank;


    public Integer getIdCountry() {
        return this.idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getFifaRank() {
        return this.fifaRank;
    }

    public void setFifaRank(Integer fifaRank) {
        this.fifaRank = fifaRank;
    }


}
