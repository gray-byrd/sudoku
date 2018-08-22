package games.sudoku.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Game {

    private Integer id;
    private Board gameBoard;
    private Board solvBoard;
    private ArrayList<String> ctrls;

    public Game(Integer id, String gameString, String solvString) {
        this.id = id;
        gameBoard = new Board().setBoard(gameString);
        solvBoard = new Board().setBoard(solvString);
    }

    public ArrayList<String> getCtrls() {
        ctrls = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            ctrls.add((gameBoard.cleared(Integer.toString(i))) ? " " : Integer.toString(i));
        }
        return ctrls;
    }

    public boolean isGameWon() {
        return !gameBoard.contains(" ");
    }
}
