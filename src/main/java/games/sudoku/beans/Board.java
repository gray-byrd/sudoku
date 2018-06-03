package games.sudoku.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Data
public class Board {
    private ArrayList<ArrayList<String>> board;

    Board(String boardString) {
        this.board = new ArrayList<>();
        IntStream.range(0,9).forEach(i -> board.add(new ArrayList<>()));
        IntStream.range(0,81).forEach(i ->
            board.get(i/9).add(boardString.substring(i,++i)));
    }

    public void setValue(int row, int col, String value) {
        board.get(row).set(col,value);
    }

    public String getValue(int row, int col) {
        return board.get(row).get(col);
    }

    public boolean contains(String value) {
        for (ArrayList<String> col: board) {
            if (col.contains(value)) {
                return true;
            }
        }
        return false;
    }
}