package games.sudoku.beans;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Game {

    private static final String boardString =
            "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
    private int score;
    private boolean status;
    private Board gameBoard;
    private Board solvBoard;
    private ArrayList<String> ctrls;

    public Game() {
        score = 0;
        status = false;
        gameBoard = new Board();
        solvBoard = new Board(boardString);
        ctrls = new ArrayList<> (9);
        for (int i = 1; i < 10; i++) {
            ctrls.add(Integer.toString(i));
        }
    }
}
