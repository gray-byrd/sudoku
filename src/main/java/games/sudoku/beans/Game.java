package games.sudoku.beans;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Game {

    private static final String boardString =
            "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
    private static final String boardString2 =
            "12345678912345 789123456789 2345678912 456789123456 891234567891 34567891234567 9";
    private int score;
    private boolean status;
    private Board gameBoard;
    private Board solvBoard;
    private ArrayList<String> ctrls;

    public Game() {
        score = 0;
        status = false;
        gameBoard = new Board(boardString2);
        solvBoard = new Board(boardString);
        ctrls = new ArrayList<> (9);
        for (int i = 1; i < 10; i++) {
            ctrls.add(Integer.toString(i));
        }
    }
}
