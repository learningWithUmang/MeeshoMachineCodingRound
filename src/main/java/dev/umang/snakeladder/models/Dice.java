package dev.umang.snakeladder.models;

import dev.umang.snakeladder.Utils.UniqueIdGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dice implements UniqueIdGenerator {
    private String color;

    @Override
    public int getRandomID() {
        return 4; //come to it later
    }
}
