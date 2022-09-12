package com.example.battleship.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Coordinates {

    private Integer x;

    private Integer y;
}
