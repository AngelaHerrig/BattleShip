package com.example.battleship.populator;

import com.example.battleship.entity.Coordinates;
import com.example.battleship.entity.Game;
import com.example.battleship.entity.Ship;
import com.example.battleship.entity.Turn;
import com.example.battleship.enumeration.Orientation;
import com.example.battleship.enumeration.ShipType;
import com.example.battleship.repository.FieldRepository;
import com.example.battleship.repository.GameRepository;
import com.example.battleship.repository.ShipRepository;
import com.example.battleship.repository.TurnRepository;
import com.example.battleship.service.ShipService;
import com.example.battleship.util.GameUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class BattleShipPopulator implements CommandLineRunner {

    private final FieldRepository fieldRepository;
    private final ShipRepository shipRepository;
    private final TurnRepository turnRepository;
    private final GameRepository gameRepository;

    private final ShipService shipService;

    @Override
    public void run(String...args){
        Ship type1_ship1 = new Ship(null, Orientation.VERTICAL, ShipType.PAPRIKA,new Coordinates(4,6));
        Ship type1_ship2 = new Ship(null, Orientation.VERTICAL, ShipType.PAPRIKA,new Coordinates(8,9));
        Ship type1_ship3 = new Ship(null, Orientation.VERTICAL, ShipType.PAPRIKA,new Coordinates(6,2));
        Ship type1_ship4 = new Ship(null, Orientation.VERTICAL, ShipType.PAPRIKA,new Coordinates(1,10));

        Ship type2_ship1 = new Ship(null, Orientation.HORIZONTAL, ShipType.CHEESE_AND_ONION,new Coordinates(7,5));
        Ship type2_ship2 = new Ship(null, Orientation.VERTICAL, ShipType.CHEESE_AND_ONION,new Coordinates(1,2));
        Ship type2_ship3 = new Ship(null, Orientation.HORIZONTAL, ShipType.CHEESE_AND_ONION,new Coordinates(4,10));

        Ship type3_ship1 = new Ship(null, Orientation.VERTICAL, ShipType.SOUR_CREAM,new Coordinates(3,2));
        Ship type3_ship2 = new Ship(null, Orientation.VERTICAL, ShipType.SOUR_CREAM,new Coordinates(10,3));

        Ship type4_ship1 = new Ship(null, Orientation.HORIZONTAL, ShipType.SALT_AND_VINEGAR,new Coordinates(3,8));

        Set<Ship> ships = new HashSet<>((Arrays.asList(type1_ship1,type1_ship2,type1_ship3,type1_ship4,type2_ship1,type2_ship2,type2_ship3,type3_ship1,type3_ship2,type4_ship1)));

        Game game1 = new Game();
        game1.getFieldPlayerOne().setShips(ships);
        gameRepository.save(game1);

        Turn turn1 = new Turn();

        turnRepository.save(turn1);

        GameUtil.drawFields(game1);

        shipService.getShipAndSurroundingCoordinates(type2_ship2);
    }

}
