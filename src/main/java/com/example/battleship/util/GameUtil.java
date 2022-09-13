package com.example.battleship.util;

import com.example.battleship.config.GameConfig;
import com.example.battleship.entity.Field;
import com.example.battleship.entity.Game;
import com.example.battleship.entity.Ship;
import com.example.battleship.enumeration.Orientation;

public class GameUtil {

    public static void drawFields(Game game) {
        GameUtil.drawField(game.getFieldPlayerOne());
        System.out.println("---".repeat(GameConfig.width + 1));
        GameUtil.drawField(game.getFieldPlayerTwo());

    }

    public static void drawField(Field field) {

//        String[][] ocean = new String[GameConfig.height+1][GameConfig.width+1];
////Feld nur mit Wasser erstellen
//        for (int x = 0; x < GameConfig.width; x++) {
//            for (int y = 0; y < GameConfig.height; y++) {
//                //Prüft ob wir in der ersten spalte/Zeile sind..wenn ja dann soll mit Zahl beschriftet werden
//                if(x ==0 || y == 0){
//                    ocean[x][y]= String.valueOf(x+y);
//                }else{
//                    ocean[y][x] = "0";
//                }
//            }
//        }

        String[][] ocean = new String[GameConfig.width + 1][GameConfig.height + 1];

        // populate with coordinates and water
        for (int x = 0; x <= GameConfig.width; x++) {
            //Prüft ob wir in der ersten spalte/Zeile sind..wenn ja dann soll die Zahl vom Koordinatensystem geschrieben werden
            for (int y = 0; y <= GameConfig.height; y++) {
                if (x == 0 || y == 0) {
                    ocean[x][y] = String.valueOf(x + y);
                } else {
                    ocean[x][y] = "□";
                }
            }
        }


//        //Schiffe platzieren
//        for (int y = 0; y <= GameConfig.height; y++) {
//            for (int x = 0; x <= GameConfig.width; x++) {
//                for (Ship ship : field.getShips()) {
//                    if (ship.getCoordinates().getY() - 1 == y && ship.getCoordinates().getX() - 1 == x) {
//                        if (ship.getOrientation().equals(Orientation.VERTICAL)) {
//                            for (int shipY = 0; shipY < ship.getShipType().length; shipY++) {
//                                ocean[y + shipY][x] = "X";
//                            }
//                        } else if (ship.getOrientation().equals(Orientation.HORIZONTAL)) {
//                            for (int shipX = 0; shipX < ship.getShipType().length; shipX++) {
//                                ocean[y][x + shipX] = "X";
//                            }
//                        }
//                    }
//                }
//            }
//        }

        // populate ships
        for (Ship ship : field.getShips()) {
            Integer x = ship.getCoordinates().getX();
            Integer y = ship.getCoordinates().getY();

            for (int length = 0; length < ship.getShipType().length; length++) {
                if (ship.getOrientation().equals(Orientation.VERTICAL)) {
                    ocean[x][y + length] = "■";
                } else {
                    ocean[x + length][y] = "■";
                }
            }
        }

        //draw
        //Ausgabe
        for (int y = 0; y <= GameConfig.height; y++) {
            for (int x = 0; x <= GameConfig.width; x++) {
                System.out.printf("%1$3s", ocean[x][y]);
            }
            System.out.println();
        }

    }
}
