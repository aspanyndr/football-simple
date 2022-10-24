package com.myexample.footballdemo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {

    // public DefaultResponse<BukuDto> savebuku(@RequestBody BukuDto bukuDto){
    //     Buku buku = convertDtoToEntity(bukuDto);
    //     DefaultResponse<BukuDto> response = new DefaultResponse();
    //     Optional<Buku> optional = bukuRepository.findByIdBuku(bukuDto.getIdBuku());
    //     if(optional.isPresent()){
    //         response.setStatus(Boolean.FALSE);
    //         response.setMessage("Error, Data Sudah Tersedia");
    //     } else {
    //         bukuRepository.save(buku);
    //         response.setStatus(Boolean.TRUE);
    //         response.setMessage("Berhasil Simpan Data");
    //     }
    //     return response;
    // }

    @Id
    @Column(name = "country_id", length  = 5)
    private Integer id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "fifa_rank")
    private String fifaRank;
    @Column(name = "country_code")
    private String countryCode;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFifaRank() {
        return this.fifaRank;
    }

    public void setFifaRank(String fifaRank) {
        this.fifaRank = fifaRank;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
}
