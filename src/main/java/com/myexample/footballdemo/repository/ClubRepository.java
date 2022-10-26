package com.myexample.footballdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexample.footballdemo.model.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer>{

    Optional<Club> findByIdClub(Integer idClub);

}
    

