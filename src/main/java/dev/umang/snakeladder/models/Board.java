package dev.umang.snakeladder.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;

    public Board(int N){
        this.board = new ArrayList<>();
        //[]
        for(int  i = 1 ; i <= N ; i++){
            List<Cell> cells = new ArrayList<>();
            for(int j = 1 ; j <= N ; j++){
                Cell cell = new Cell(i,j);
                cells.add(cell);
            }
            board.add(cells);
        }
    }

    public  void  showBoard(){

    }
}
