package com.example.battleship.enumeration;

public enum ShipType {
    PAPRIKA(1),
    CHEESE_AND_ONION(2),
    SOUR_CREAM(3),
    SALT_AND_VINEGAR(4);

    public final Integer length;

    ShipType(Integer length) {
        this.length = length;
    }
}
