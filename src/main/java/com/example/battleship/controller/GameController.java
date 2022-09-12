package com.example.battleship.controller;


import com.example.battleship.dto.GameDtoUpdate;
import com.example.battleship.entity.Game;
import com.example.battleship.service.GameService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("battleship")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    private final ModelMapper modelMapper;

    @PutMapping

    public ResponseEntity<Game> placeShips(@Valid @RequestBody GameDtoUpdate gameDtoUpdate) {
        Game game = modelMapper.map(gameDtoUpdate,Game.class);
        return new ResponseEntity<>(gameService.placeShips(game), HttpStatus.OK);
    }
}
