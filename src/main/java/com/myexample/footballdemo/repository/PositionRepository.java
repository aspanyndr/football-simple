package com.myexample.footballdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexample.footballdemo.model.entity.PosPlayer;

@Repository
public interface PositionRepository extends JpaRepository<PosPlayer, Integer> {

    Optional <PosPlayer> findByIdPosition(Integer idPosition);
    
}
