package com.myexample.footballdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myexample.footballdemo.model.entity.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

    Optional <Position> findByIdPosition(Integer idPosition);
    
}
