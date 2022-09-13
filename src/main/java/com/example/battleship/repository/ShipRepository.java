package com.example.battleship.repository;

import com.example.battleship.entity.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends CrudRepository<Ship,Long> {
}
