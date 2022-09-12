package com.example.battleship.entity;

import com.example.battleship.enumeration.Player;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer turn;

    @Enumerated(value = EnumType.STRING)
    private Player player;

    private Coordinates coordinates;

    private Boolean hit;
}
