package games.sudoku.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Data
public class Board {
    private String selected;
    private ArrayList<ArrayList<Cell>> board;

    Board(String boardString) {
        this.selected = "";
        this.board = new ArrayList<>();
        IntStream.range(0,9).forEach(i -> board.add(new ArrayList<>()));
        IntStream.range(0,81).forEach(i ->
            board.get(i/9).add(new Cell(boardString.substring(i,++i))));
    }

    public String getValue(int row, int col) {
        return board.get(row).get(col).getValue();
    }

    public void setValue(int row, int col, String value) {
        selected = value;
        board.get(row).get(col).setValue(value);
    }

    public String getBoardString() {
        StringBuilder sb = new StringBuilder();
        board.forEach(i -> i.forEach(j -> sb.append(j.getValue())));
        return sb.toString();
    }

    public boolean contains(String value) {
        for (ArrayList<Cell> col: board) {
            for (Cell cell: col) {
                if (value.equals(cell.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cleared(String value) {
        int count = 0;
        for (ArrayList<Cell> col: board) {
            for (Cell cell: col) {
                if (value.equals(cell.getValue())) count++;
            }
        }
        return count > 8;
    }

    public boolean checkNeighbors(int row, int col, String value) {
        return checkRow(row, col, value)
                || checkCol(row, col, value)
                || checkCell(row, col, value);
    }

    private boolean checkRow(int row, int col, String value) {
        for (int i = 0; i < 9; i++) {
            if (getValue(row, i).equals(value) && !(i == col)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int row, int col, String value) {
        for (int i = 0; i < 9; i++) {
            if (getValue(i, col).equals(value) && !(i == row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCell(int row, int col, String value) {
        for (int i = 0; i < 3; i++) {
            if (getValue(row%3*3+i,col%3*3+i).equals(value)
                    && !((row%3*3+i == row) && (col%3*3+i == col))) {
                return true;
            }
        }
        return false;
    }
}