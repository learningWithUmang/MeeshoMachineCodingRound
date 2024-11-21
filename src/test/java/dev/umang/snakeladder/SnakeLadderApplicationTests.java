package dev.umang.snakeladder;

import dev.umang.snakeladder.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SnakeLadderApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testingScenarios(){
        Player p1 = new Player("Shubham", new Cell(1,1), 0);
        Player p2 = new Player("Umang", new Cell(1,1), 1);
        Player p3 = new Player("Yatin", new Cell(1,1), 2);

        List<Player> players = new ArrayList<>();
        players.add(p1); players.add(p2); players.add(p3);

        int dimension = 8;
        Board board = new Board(dimension);
        Dice dice = new Dice();
        dice.setColor("RED");

        Game game = new Game(dimension, players, dice, board);
        HashMap<Cell, Cell> snakesMap = new HashMap<>();
        HashMap<Cell, Cell> laddersMap = new HashMap<>();

        Cell cell = new Cell(2,2);


        snakesMap.put(new Cell(2,2) , new Cell(6,8));
        snakesMap.put(new Cell(8,7) , new Cell(4,2));

        laddersMap.put(new Cell(1,5) , new Cell(8,1));
        laddersMap.put(new Cell(8,1) , new Cell(8,7));

        game.setLaddersMap(laddersMap);
        game.setSnakesMap(snakesMap);
        game.setGameStatus(GameStatus.IN_PROGRESS);

        //while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            Player playerToMakeMove = game.getCurrentPlayer();


            Move move = game.makeMove(playerToMakeMove);

        System.out.println();
            //game.getMoves().add(move);
            /*
            Check for winner as well
             */
        //}


    }

}
