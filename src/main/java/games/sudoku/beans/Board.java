package games.sudoku.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Data
public class Board {
    private List<String> gameBoard;

    public Board(String boardString) {
        this.gameBoard = new ArrayList<>();
        boardString.chars().mapToObj(c -> (char)c).forEach(c -> gameBoard.add(c.toString()));
    }

    public List<String> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(List<String> gameBoard) {
        this.gameBoard = gameBoard;
    }
}