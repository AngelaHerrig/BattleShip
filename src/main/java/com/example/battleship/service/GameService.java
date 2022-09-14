package com.example.battleship.service;

import com.example.battleship.entity.Coordinates;
import com.example.battleship.entity.Game;
import com.example.battleship.entity.Ship;
import com.example.battleship.entity.Turn;
import com.example.battleship.repository.GameRepository;
import com.example.battleship.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class GameService {

    private GameRepository gameRepository;
    private TurnRepository turnRepository;
    public GameService(@Autowired GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return (List<Game>) this.gameRepository.findAll();
    }

    public Game getGame(Long id) {
        return this.gameRepository.findById(id).orElseThrow( //orElseThrow ist ein Optional (siehe ToDoServiceTest)
                () -> new EntityNotFoundException(String.valueOf(id)));

    }
    public Game createGame(Game game) {
        return this.gameRepository.save(game);
    }



    public Turn fire(Turn turn){ return this.turnRepository.save(turn);}

}
