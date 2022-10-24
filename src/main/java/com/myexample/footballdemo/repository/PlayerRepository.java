package com.myexample.footballdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexample.footballdemo.model.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

    Optional<Player> findById(Integer id);

    
}
