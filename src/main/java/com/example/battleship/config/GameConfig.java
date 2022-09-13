package com.example.battleship.config;

import com.example.battleship.enumeration.ShipType;

import java.util.HashMap;
import java.util.Map;

public class GameConfig {

    public static Integer width = 10;
    public static Integer height = 10;

    public static Map<ShipType, Integer> ships = new HashMap<>();

    static {
        ships.put(ShipType.PAPRIKA, 4);
        ships.put(ShipType.CHEESE_AND_ONION, 3);
        ships.put(ShipType.SOUR_CREAM, 2);
        ships.put(ShipType.SALT_AND_VINEGAR, 1);
    }
}
