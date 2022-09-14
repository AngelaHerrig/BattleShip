package com.example.battleship.controller;

import com.example.battleship.entity.Field;
import com.example.battleship.entity.Game;
import com.example.battleship.entity.Turn;
import com.example.battleship.repository.FieldRepository;
import com.example.battleship.repository.GameRepository;
import com.example.battleship.service.FieldService;
import com.example.battleship.service.GameService;
import com.example.battleship.service.KIService;
import com.example.battleship.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("battleship")
@RequiredArgsConstructor
public class GameController {
    @Autowired
    private final GameService gameService;
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    private final ShipService shipService;
    private final KIService kiService;


    private final FieldService fieldService;
    private final FieldRepository fieldRepository;

    @GetMapping
    public ResponseEntity<List> getAllGames() {

        return new ResponseEntity(gameService.getAllGames(), HttpStatus.OK);
    }

    //Leeres Spiel:
//    {
//        "id": 4,
//            "fieldPlayerOne": {
//        "id": 8,
//                "ships": []
//    },
//        "fieldPlayerTwo": {
//        "id": 9,
//                "ships": []
//    },
//        "turns": [],
//        "difficulty": "EASY"
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> get(@PathVariable("id") Long id) {
        return ResponseEntity.status(200).body(gameService.getGame(id));
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game game) {
        return new ResponseEntity<>(gameService.createGame(modelMapper.map(game, Game.class)), HttpStatus.CREATED);
    }


    @PutMapping("/{id}/placeShips") //id vom game
    public ResponseEntity<Game> placeShips(@RequestBody Game game, @PathVariable("id") Long id, Field field) {

        Field placePlayerOne = game.getFieldPlayerOne();
        placePlayerOne.setShips(kiService.placeShips());

        Field placePlayerTwo = game.getFieldPlayerTwo();
        placePlayerTwo.setShips(kiService.placeShips());

        return new ResponseEntity<>(gameService.createGame(modelMapper.map(game, Game.class)), HttpStatus.OK);

    }

    @PutMapping("/{id}/fire")
    public ResponseEntity<Game> fire(@RequestBody Game game,Set<Turn> turn, @PathVariable("id") Long id) {

//        Game testGame = (Game) game.getTurns();
        Set<Turn> testTurn = game.getTurns();
//        Turn currentTurn = (Turn) game.getTurns();
//        currentTurn.setTurn(1);

        System.out.println(testTurn);
        //id ---automatisch
        //turn:1++ ---calc aktueller Wert +1
        //player: PLAYER_ONE or PLAYER_TWO --- if hit is true do nothing, if hit is false switch player
        //coordinates: x , y ---check hit
        //hit: false or true ----if hit change to true
        return new ResponseEntity<>(gameService.createGame(modelMapper.map(game, Game.class)), HttpStatus.OK);

    }
}
