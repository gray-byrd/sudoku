package games.sudoku.beans;

import java.util.Arrays;

public class Board {

    private Integer[][] gameBoard;
    private Integer[][] solutionBoard;

    public Board(String str) {
        this.gameBoard = new Integer[9][9];
        this.solutionBoard = new Integer[9][9];
        for (int x = 0; x < 9; x++) {
            for(int y = 0; y < 9; y++) {
                this.gameBoard[x][y] = Integer.parseInt(str.substring(x*9+y, x*9+y+1));
                this.solutionBoard[x][y] = Integer.parseInt(str.substring(x*9+y, x*9+y+1));
            }
        }
    }

    public int getFromPosition(int x, int y) {
        return this.gameBoard[x][y];
    }

    public void setToPosition(int value, int x, int y) {
        gameBoard[x][y] = value;
    }

    public void drawBoard() {
        for (Integer[] row: this.gameBoard) {
            System.out.println(Arrays.toString(gameBoard));
        }
    }
}
