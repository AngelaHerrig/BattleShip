package com.example.battleship.entity;

import com.example.battleship.enumeration.Difficulty;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Field fieldPlayerOne = new Field();

    @OneToOne(cascade = CascadeType.ALL)
    private Field fieldPlayerTwo = new Field();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Turn> turns = new HashSet<>();

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty = Difficulty.EASY;

}
