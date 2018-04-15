package games.sudoku.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Data
public class Board {
    private ArrayList<ArrayList<String>> gameBoard;

    public Board(String boardString) {
        this.gameBoard = new ArrayList<>();
        IntStream.range(0,9).forEach(i -> gameBoard.add(new ArrayList<>()));
        IntStream.range(0,boardString.length()).forEach(i ->
            gameBoard.get(i/9).add(boardString.substring(i,++i)));
    }
}