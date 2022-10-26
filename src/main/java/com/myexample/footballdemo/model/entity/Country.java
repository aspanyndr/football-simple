package com.myexample.footballdemo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_country")
public class Country {

    @Id
    @Column(name = "id_country")
    private Integer idCountry;
    @Column
    private String countryName;
    @Column
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
