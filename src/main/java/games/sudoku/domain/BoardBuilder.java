package games.sudoku.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class BoardBuilder {

    private Board board;

    public BoardBuilder() {
        board = new Board();
    }

    public BoardBuilder(Board board) {
        this.board = board;
    }

    public Board build() {
        return board;
    }

    public BoardBuilder fillBoard() {
        for (int i = 0; i < board.getSize()*board.getSize(); i++) {
            List<String> setList = new ArrayList<>();
            IntStream.rangeClosed(1,9).forEach(num -> setList.add(Integer.toString(num)));
            Collections.shuffle(setList);
            Boolean notFound = true;
            for (String value: setList) {
                if (!board.checkNeighbors(i / board.getSize(), i % board.getSize(), value)) {
                    board.setValue(i / board.getSize(), i % board.getSize(), value);
                    notFound = false;
                    break;
                }
            }
            if (notFound) {
                break;
            }
        }
        System.out.println(this.build());
        return this.build().allCleared() ? this : new BoardBuilder().fillBoard();
    }
}
