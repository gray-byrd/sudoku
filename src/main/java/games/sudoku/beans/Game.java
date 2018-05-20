package games.sudoku.beans;

import lombok.Data;

@Data
public class Game {

    private static final String boardString =
            "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
    private boolean status;
    private Board gameBoard;
    private Board solvBoard;

    public Game() {
        this.status = false;
        this.gameBoard = new Board();
        this.solvBoard = new Board(boardString);
    }
}
