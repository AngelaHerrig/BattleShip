package com.example.battleship.service;

import com.example.battleship.config.GameConfig;
import com.example.battleship.entity.Coordinates;
import com.example.battleship.entity.Field;
import com.example.battleship.entity.Ship;
import com.example.battleship.enumeration.Orientation;
import com.example.battleship.enumeration.ShipType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FieldService {

    private final ShipService shipService;

    public Boolean areCorrectAmountOfShipsPlaced(Field field) {

        final long AMOUNT_SHIP_1 = GameConfig.ships.get(ShipType.PAPRIKA);
        final long AMOUNT_SHIP_2 = GameConfig.ships.get(ShipType.CHEESE_AND_ONION);
        final long AMOUNT_SHIP_3 = GameConfig.ships.get(ShipType.SOUR_CREAM);
        final long AMOUNT_SHIP_4 = GameConfig.ships.get(ShipType.SALT_AND_VINEGAR);

        final long FIELD_SHIP_1 = field.getShips().stream().filter(ship -> ship.getShipType().equals(ShipType.PAPRIKA)).count();
        final long FIELD_SHIP_2 = field.getShips().stream().filter(ship -> ship.getShipType().equals(ShipType.CHEESE_AND_ONION)).count();
        final long FIELD_SHIP_3 = field.getShips().stream().filter(ship -> ship.getShipType().equals(ShipType.SOUR_CREAM)).count();
        final long FIELD_SHIP_4 = field.getShips().stream().filter(ship -> ship.getShipType().equals(ShipType.SALT_AND_VINEGAR)).count();

        return (
                AMOUNT_SHIP_1 == FIELD_SHIP_1 &&
                        AMOUNT_SHIP_2 == FIELD_SHIP_2 &&
                        AMOUNT_SHIP_3 == FIELD_SHIP_3 &&
                        AMOUNT_SHIP_4 == FIELD_SHIP_4
        );

    }

    public Boolean areShipsPlacedEntirelyOnTheField(Field field) {
        for (Ship ship : field.getShips()) {
            final int x = ship.getCoordinates().getX();
            final int y = ship.getCoordinates().getY();
            final int length = ship.getShipType().length;

            if (x < 1 || x > GameConfig.width || y < 1 || y > GameConfig.height)
                return false;

            if (ship.getOrientation() == Orientation.VERTICAL) {
                if ((y + length - 1) > GameConfig.height)
                    return false;
            } else {
                if ((x + length - 1) > GameConfig.width)
                    return false;
            }
        }
        return true;
    }

    public Boolean haveShipsEnoughClearance(Field field){
        for(Ship ship : field.getShips()){
            Set<Coordinates> clearanceCoordinates = shipService.getShipAndSurroundingCoordinates(ship);
            Set<Ship> otherShips = field.getShips().stream().filter(s -> !s.getId().equals(ship.getId())).collect(Collectors.toSet());


            Set<Coordinates> otherCoordinates = otherShips.stream().map(shipService::getAllCoordinatesFromShip).flatMap(Collection::stream).collect(Collectors.toSet()); //flatMap bringt alle Listen in eine Liste
            for(Coordinates c : clearanceCoordinates){
                if(otherCoordinates.contains(c))
                    return false;
            }

            //Alternativ:
//            if (!Collections.disjoint(clearanceCoordinates, otherCoordinates))
//                return false;
        }
        return true;
    }


}
