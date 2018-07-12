package games.sudoku.domain;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {

    private Board board;

    @Test
    public void BuildBoardTest() {
        String boardString =
                "123456789234567891345678912456789123567891234678912345789123456891234567912345678";
        board = new Board(boardString);
        boolean pass = true;
        for (int i = 0; i < 81; i ++) {
            if (!boardString.substring(i,i+1).equals(
                    board.getBoard().get(i/9).get(i%9).getValue())) {
                pass = false;
                break;
            }
        }
        assert pass;
    }

    @Test
    public void getValueTest() {
        board = new Board(
                "                                        4                                        ");
        assert board.getValue(4,4).equals("4");
    }

    @Test
    public void setValueTest() {
        board = new Board(
                "                                                                                 ");
        board.setValue(4,4,"4");
        assert board.getValue(4,4).equals("4");
    }

    @Test
    public void contains_ContainsTest() {
        board = new Board(
                "                                        4                                        ");
        assert board.contains("4");
    }

    @Test
    public void contains_NotContainsTest() {
        board = new Board(
                "                                        4                                        ");
        assert !board.contains("5");
    }

    @Test
    public void cleared_isCleared() {
        board = new Board(
                "4        4        4        4        4        4        4        4        4        ");
        assert board.cleared("4");
    }

    @Test
    public void cleared_isNotCleared() {
        board = new Board(
                "                                        4                                        ");
        assert !board.cleared("4");
    }

    @Test
    public void checkNeighbors_InRowTest() {
        board = new Board(
                "                                            4                                    ");
        assert board.checkNeighbors(4,4,"4");
    }
    @Test
    public void checkNeighbors_InColumnTest() {
        board = new Board(
                "                                                          4                      ");
        assert board.checkNeighbors(4,4,"4");
    }
    @Test
    public void checkNeighbors_InBlockTest() {
        board = new Board(
                "                                                  4                              ");
        assert board.checkNeighbors(4,4,"4");
    }
    @Test
    public void checkNeighbors_NoNeighborsTest() {
        board = new Board(
                "                                        4                                        ");
        assert !board.checkNeighbors(4,4,"4");
    }

    @Test
    public void testToBoardString() {
        String boardString =
                "123456789234567891345678912456789123567891234678912345789123456891234567912345678";
        board = new Board(boardString);
        assert boardString.equals(board.getBoardString());
    }
}
