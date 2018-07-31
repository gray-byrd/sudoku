package games.sudoku.domain;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Data
public class Board {
    private  Integer size = 9;
    private String selected;
    private ArrayList<ArrayList<Cell>> board;

    Board() {
        this.selected = "";
        this.board = new ArrayList<>();
        IntStream.range(0,size).forEach(i -> board.add(new ArrayList<>()));
        IntStream.range(0,size*size).forEach(i ->
                board.get(i/size).add(new Cell("")));
    }

    public Board setBoard(String boardString){
        IntStream.range(0,size*size).forEach(i ->
                board.get(i/size).get(i%size).setValue(boardString.substring(i,++i)));
        return this;
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
        return count == size;
    }

    public boolean allCleared() {
        boolean cleared = true;
        for (Integer value = 1; value <= size; value++) {
            if (!this.cleared(value.toString())) {
                cleared = false;
            }
        }
        return cleared;
    }

    public boolean checkNeighbors(int row, int col, String value) {
        return checkRow(row, col, value)
                || checkCol(row, col, value)
                || checkCell(row, col, value);
    }

    private boolean checkRow(int row, int col, String value) {
        for (int i = 0; i < size; i++) {
            if (getValue(row, i).equals(value) && !(i == col)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int row, int col, String value) {
        for (int i = 0; i < size; i++) {
            if (getValue(i, col).equals(value) && !(i == row)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCell(int row, int col, String value) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (getValue(row/3*3+i,col/3*3+j).equals(value)
                        && !((row/3*3+i == row) && (col/3*3+j == col))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Board{" +
                "selected='" + selected + '\'' +
                ", board=" + printBoard() +
                '}';
    }

    private String printBoard () {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------------------------------------");
        for (int i = 1; i <= size; i++) {
            stringBuilder.append("\n|");
            for (int j = 1; j <= size; j++) {
                Cell cell = board.get(i - 1).get(j - 1);
                stringBuilder.append(" ").append(StringUtils.isNotBlank(cell.getValue()) ? cell.getValue() : ".").append(" ");
                if (j % 3 == 0) {
                    stringBuilder.append(" | ");
                }
            }
            if (i % 3 == 0) {
                stringBuilder.append("\n------------------------------------");
            }
        }
        return stringBuilder.toString();
    }
}