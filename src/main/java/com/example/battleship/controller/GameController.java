package com.example.battleship.controller;


import com.example.battleship.dto.GameDtoUpdate;
import com.example.battleship.entity.Game;
import com.example.battleship.service.GameService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("battleship")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    private final ModelMapper modelMapper;




//    @PostMapping
//    public ResponseEntity<Game> create() {
//        return new ResponseEntity<>(gameService.createGame(), HttpStatus.CREATED);
//    }

    @PutMapping("/{id}/placeShips")
    public ResponseEntity<Game> placeShips() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/{id}/fire")
    public ResponseEntity<Game> fire() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
