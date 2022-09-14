package com.example.battleship.service;

import com.example.battleship.config.GameConfig;
import com.example.battleship.entity.Coordinates;
import com.example.battleship.entity.Ship;
import com.example.battleship.enumeration.Orientation;
import com.example.battleship.repository.ShipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipService {

    private final ShipRepository shipRepository;

    public List<Ship> getAllShips() {
        return (List<Ship>) this.shipRepository.findAll();
    }


    public Set<Coordinates> getAllCoordinatesFromShip(Ship ship) {
        Set<Coordinates> coordinates = new HashSet<>();

        for (int length = 0; length < ship.getShipType().length; length++) {
            final int x = ship.getCoordinates().getX();
            final int y = ship.getCoordinates().getY();
            if (ship.getOrientation().equals(Orientation.VERTICAL)) {

                coordinates.add(new Coordinates(x, y + length));
            } else {
                coordinates.add(new Coordinates(x + length, y));
            }
        }

        return coordinates;
    }


    public Set<Coordinates> getShipAndSurroundingCoordinates(Ship ship) {
        Set<Coordinates> surroundingCoordinates = new HashSet<>();

        for (Coordinates shipCoordinate : getAllCoordinatesFromShip(ship)) {
            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                  surroundingCoordinates.add(new Coordinates(shipCoordinate.getX() + x, shipCoordinate.getY() + y));
                }
            }
        }

        return surroundingCoordinates;
    }

    public Boolean isShipPlacedEntirelyOnTheField(Ship ship) {
        final int x = ship.getCoordinates().getX();
        final int y = ship.getCoordinates().getY();
        final int length = ship.getShipType().length;

        if (x < 1 || x > GameConfig.width || y < 1 || y > GameConfig.height)
            return false;

        if (ship.getOrientation().equals(Orientation.HORIZONTAL)) {
            return (x + length - 1) <= GameConfig.width;
        } else {
            return (y + length - 1) <= GameConfig.height;
        }
    }

    public Boolean isShipPlacementValid(Ship ship, Set<Ship> otherShips) {
        if (!isShipPlacedEntirelyOnTheField(ship))
            return false;

        Set<Coordinates> clearanceCoordinates = this.getShipAndSurroundingCoordinates(ship);
        Set<Coordinates> otherCoordinates = otherShips.stream().map(this::getAllCoordinatesFromShip).flatMap(Collection::stream).collect(Collectors.toSet());

        return Collections.disjoint(clearanceCoordinates, otherCoordinates);
    }

}