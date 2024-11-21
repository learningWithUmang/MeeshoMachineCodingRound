package dev.umang.snakeladder.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

@Getter
@Setter
public class Game {
    private int dimension;
    private Board board;
    private HashMap<Cell,Cell> snakesMap;
    private HashMap<Cell,Cell> laddersMap;
    private Queue<Player> players;
    private Dice dice;
    private GameStatus gameStatus;
    private Player winner;
    private List<Move> moves;


    public Game(int dimension, List<Player> players, Dice dice, Board board){
        this.board = board;
        this.players = new ArrayDeque<>(players);
        this.dice = dice;
        this.dimension = dimension;
    }

    public Player getCurrentPlayer(){
        Player p = players.poll();
        players.add(p);
        return p;
    }

    //

    public Move makeMove(Player player){
        int steps = dice.getRandomID();
        Cell currentCell = player.getCell();

        //5 steps dice - 5 (1,2) - (1,7)

        Cell destinationCell = getTargetCell(currentCell, steps); //5,8
        //invalid, ladder, snake

        if(!destinationCell.checkForValid(dimension)){
            return new Move(player, currentCell, destinationCell, MoveType.INVALID);
        }

        Cell targetCell = getTargetCell(currentCell, steps);

        player.setCell(targetCell);
        return new Move(player, currentCell, targetCell, MoveType.ACTUAL);

    }

    Cell getTargetCell(Cell currentCell, int steps){
        int row = currentCell.getRow();
        int col = currentCell.getCol();

        int targetCol = (col + steps); //N = 9, 5 + 6 = 11

        int remainingSteps = Math.max(0, targetCol - dimension); //2

        targetCol -= remainingSteps; //

        col = targetCol;

        if(remainingSteps > 0){
            row = row + 1;
            col = dimension - remainingSteps;
        }

        return getFinalCell(new Cell(row, col));
    }

    Cell getFinalCell(Cell cell){
        if(snakesMap.get(cell) != null){
            Cell nextCell = snakesMap.get(cell);
            return getFinalCell(nextCell);
        }
        if(laddersMap.get(cell) != null) {
            Cell nextCell = laddersMap.get(cell);
            return getFinalCell(nextCell);
        }
        return cell;
    }
}
