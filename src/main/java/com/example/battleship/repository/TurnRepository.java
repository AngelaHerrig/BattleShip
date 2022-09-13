package com.example.battleship.repository;

import com.example.battleship.entity.Turn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends CrudRepository<Turn,Long> {
}
