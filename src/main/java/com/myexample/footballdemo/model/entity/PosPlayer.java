package com.myexample.footballdemo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_postion")
public class PosPlayer {

    @Id
    @Column(name="id_position")
    private Integer idPosition;
    @Column
    private String position;



    public Integer getIdPosition() {
        return this.idPosition;
    }

    public void setIdPosition(Integer idPosition) {
        this.idPosition = idPosition;
    }
    

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
