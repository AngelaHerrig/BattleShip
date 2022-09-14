package com.example.battleship.controller;

import com.example.battleship.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("battleship/ship")
@RequiredArgsConstructor
public class ShipController {

        private final ShipService shipService;


        @GetMapping
        public ResponseEntity<List> getAllShips() {

            return new ResponseEntity(shipService.getAllShips(), HttpStatus.OK);
        }


    }


