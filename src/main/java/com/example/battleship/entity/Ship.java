package com.example.battleship.entity;

import com.example.battleship.enumeration.Orientation;
import com.example.battleship.enumeration.ShipType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Orientation orientation;

    @Enumerated(value = EnumType.STRING)
    private ShipType shipType;

    private Coordinates coordinates;
}
