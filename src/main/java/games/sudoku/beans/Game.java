package games.sudoku.beans;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Game {

    private static final String gameString =
            "462581 9391876 52475 942681526 198371396 824584732591 2718543693851964726 4237158";
    private static final String solvString =
            "462581793918763524753942681526419837139678245847325916271854369385196472694237158";

    private int score;
    private boolean status;
    private Board gameBoard;
    private Board solvBoard;
    private ArrayList<String> ctrls;

    public Game() {
        score = 0;
        status = false;
        gameBoard = new Board(gameString);
        solvBoard = new Board(solvString);
    }

    public ArrayList<String> getCtrls() {
        ctrls = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            ctrls.add((gameBoard.cleared(Integer.toString(i))) ? " " : Integer.toString(i));
        }
        return ctrls;
    }
}
