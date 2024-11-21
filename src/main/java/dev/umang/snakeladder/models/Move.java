package dev.umang.snakeladder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Move {
    private Player player;
    private Cell source;
    private Cell destination;

    private MoveType moveType;


}
