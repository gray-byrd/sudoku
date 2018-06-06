package games.sudoku.beans;

import lombok.Data;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Data
public class Board {
    private String selected;
    private ArrayList<ArrayList<String>> board;

    Board(String boardString) {
        this.selected = "";
        this.board = new ArrayList<>();
        IntStream.range(0,9).forEach(i -> board.add(new ArrayList<>()));
        IntStream.range(0,81).forEach(i ->
            board.get(i/9).add(boardString.substring(i,++i)));
    }

    public void setValue(int row, int col, String value) {
        selected = value;
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

    public boolean cleared(String value) {
        int count = 0;
        for (ArrayList<String> col: board) {
            for (String square: col) {
                if (value.equals(square)) count++;
            }
        }
        return count > 8;
    }
}