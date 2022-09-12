package com.example.battleship.service;

import com.example.battleship.entity.Game;
import com.example.battleship.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(@Autowired GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game placeShips(Game game) {
        return this.gameRepository.save(game);
    }
}
