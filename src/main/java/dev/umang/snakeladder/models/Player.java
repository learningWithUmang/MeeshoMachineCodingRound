package dev.umang.snakeladder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private String name;

    private Cell cell;
    private int symbol;


}
