package com.example.battleship.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@EqualsAndHashCode //vergleicht Werte anstatt Speicherort des Objekts
public class Coordinates {

    private Integer x;

    private Integer y;
}
