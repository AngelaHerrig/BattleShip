package com.example.battleship.config;

import com.example.battleship.enumeration.ShipType;

import java.util.HashMap;
import java.util.Map;

public class GameConfig {

    public static Integer width = 10;
    public static Integer height = 10;

    public static Map<ShipType, Integer> ships = new HashMap<>();

    static {
        ships.put(ShipType.SHIP_1, 4);
        ships.put(ShipType.SHIP_2, 3);
        ships.put(ShipType.SHIP_3, 2);
        ships.put(ShipType.SHIP_4, 1);
    }
}
