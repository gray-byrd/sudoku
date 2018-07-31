package games.sudoku.domain;

import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardTest.class);
    private Board board;

    @Test
    public void BoardConstructorTest() {

    }

    @Test
    public void BuildBoardTest() {
        String boardString = "" +
                "123456789" +
                "234567891" +
                "345678912" +
                "456789123" +
                "567891234" +
                "678912345" +
                "789123456" +
                "891234567" +
                "912345678";
        board = new Board().setBoard(boardString);
        boolean pass = true;
        for (int i = 0; i < 81; i ++) {
            if (!boardString.substring(i,i+1).equals(
                    board.getBoard().get(i/9).get(i%9).getValue())) {
                pass = false;
                break;
            }
        }
        LOGGER.debug(board.toString());
        assert pass;
    }

    @Test
    public void getValueTest() {
        board = new Board().setBoard("" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000040000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000");
        LOGGER.debug(board.toString());
        assert board.getValue(4,4).equals("4");
    }

    @Test
    public void setValueTest() {
        board = new Board().setBoard("" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000");
        board.setValue(4,4,"4");
        LOGGER.debug(board.toString());
        assert board.getValue(4,4).equals("4");
    }

    @Test
    public void contains_ContainsTest() {
        board = new Board().setBoard("" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000040000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000");
        LOGGER.debug(board.toString());
        assert board.contains("4");
    }

    @Test
    public void contains_NotContainsTest() {
        board = new Board().setBoard("" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000040000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000");
        LOGGER.debug(board.toString());
        assert !board.contains("5");
    }

    @Test
    public void cleared_isCleared() {
        board = new Board().setBoard("" +
                "400000000" +
                "400000000" +
                "400000000" +
                "400000000" +
                "400000000" +
                "400000000" +
                "400000000" +
                "400000000" +
                "400000000");
        LOGGER.debug(board.toString());
        assert board.cleared("4");
    }

    @Test
    public void cleared_isNotCleared() {
        board = new Board().setBoard("" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000040000" +
                "000000000" +
                "000000000" +
                "000000000" +
                "000000000");
        LOGGER.debug(board.toString());
        assert !board.cleared("4");
    }

    @Test
    public void checkNeighbors_InRowTest() {
        board = new Board().setBoard("" +
                "9999 9999" +
                "9999 9999" +
                "9999 9999" +
                "999   999" +
                "123495678" +
                "999   999" +
                "9999 9999" +
                "9999 9999" +
                "9999 9999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(4,4,"1");
        assert board.checkNeighbors(4,4,"2");
        assert board.checkNeighbors(4,4,"3");
        assert board.checkNeighbors(4,4,"4");
        assert board.checkNeighbors(4,4,"5");
        assert board.checkNeighbors(4,4,"6");
        assert board.checkNeighbors(4,4,"7");
        assert board.checkNeighbors(4,4,"8");
        assert !board.checkNeighbors(4,4,"9");
    }

    @Test
    public void checkNeighbors_InColumnTest() {
        board = new Board().setBoard("" +
                "999919999" +
                "999929999" +
                "999939999" +
                "999 4 999" +
                "    9    " +
                "999 5 999" +
                "999969999" +
                "999979999" +
                "999989999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(4,4,"1");
        assert board.checkNeighbors(4,4,"2");
        assert board.checkNeighbors(4,4,"3");
        assert board.checkNeighbors(4,4,"4");
        assert board.checkNeighbors(4,4,"5");
        assert board.checkNeighbors(4,4,"6");
        assert board.checkNeighbors(4,4,"7");
        assert board.checkNeighbors(4,4,"8");
        assert !board.checkNeighbors(4,4,"9");
    }

    @Test
    public void checkNeighbors_InBlock1_Test() {
        board = new Board().setBoard("" +
                "798      " +
                "456999999" +
                "123999999" +
                "9 9999999" +
                "9 9999999" +
                "9 9999999" +
                "9 9999999" +
                "9 9999999" +
                "9 9999999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(0,1,"1");
        assert board.checkNeighbors(0,1,"2");
        assert board.checkNeighbors(0,1,"3");
        assert board.checkNeighbors(0,1,"4");
        assert board.checkNeighbors(0,1,"5");
        assert board.checkNeighbors(0,1,"6");
        assert board.checkNeighbors(0,1,"7");
        assert board.checkNeighbors(0,1,"8");
        assert !board.checkNeighbors(0,1,"9");
    }

    @Test
    public void checkNeighbors_InBlock2_Test() {
        board = new Board().setBoard("" +
                "999876999" +
                "   195   " +
                "999234999" +
                "9999 9999" +
                "9999 9999" +
                "9999 9999" +
                "9999 9999" +
                "9999 9999" +
                "9999 9999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(1,4,"1");
        assert board.checkNeighbors(1,4,"2");
        assert board.checkNeighbors(1,4,"3");
        assert board.checkNeighbors(1,4,"4");
        assert board.checkNeighbors(1,4,"5");
        assert board.checkNeighbors(1,4,"6");
        assert board.checkNeighbors(1,4,"7");
        assert board.checkNeighbors(1,4,"8");
        assert !board.checkNeighbors(1,4,"9");
    }

    @Test
    public void checkNeighbors_InBlock3_Test() {
        board = new Board().setBoard("" +
                "999999876" +
                "999999145" +
                "      239" +
                "99999999 " +
                "99999999 " +
                "99999999 " +
                "99999999 " +
                "99999999 " +
                "99999999 ");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(2,8,"1");
        assert board.checkNeighbors(2,8,"2");
        assert board.checkNeighbors(2,8,"3");
        assert board.checkNeighbors(2,8,"4");
        assert board.checkNeighbors(2,8,"5");
        assert board.checkNeighbors(2,8,"6");
        assert board.checkNeighbors(2,8,"7");
        assert board.checkNeighbors(2,8,"8");
        assert !board.checkNeighbors(2,8,"9");
    }

    @Test
    public void checkNeighbors_InBlock4_Test() {
        board = new Board().setBoard("" +
                " 99999999" +
                " 99999999" +
                " 99999999" +
                "912      " +
                "345999999" +
                "678999999" +
                " 99999999" +
                " 99999999" +
                " 99999999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(3,0,"1");
        assert board.checkNeighbors(3,0,"2");
        assert board.checkNeighbors(3,0,"3");
        assert board.checkNeighbors(3,0,"4");
        assert board.checkNeighbors(3,0,"5");
        assert board.checkNeighbors(3,0,"6");
        assert board.checkNeighbors(3,0,"7");
        assert board.checkNeighbors(3,0,"8");
        assert !board.checkNeighbors(3,0,"9");
    }

    @Test
    public void checkNeighbors_InBlock5_Test() {
        board = new Board().setBoard("" +
                "99999 999" +
                "99999 999" +
                "99999 999" +
                "999123999" +
                "   459   " +
                "999678999" +
                "99999 999" +
                "99999 999" +
                "99999 999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(4,5,"1");
        assert board.checkNeighbors(4,5,"2");
        assert board.checkNeighbors(4,5,"3");
        assert board.checkNeighbors(4,5,"4");
        assert board.checkNeighbors(4,5,"5");
        assert board.checkNeighbors(4,5,"6");
        assert board.checkNeighbors(4,5,"7");
        assert board.checkNeighbors(4,5,"8");
        assert !board.checkNeighbors(4,5,"9");
    }

    @Test
    public void checkNeighbors_InBlock6_Test() {
        board = new Board().setBoard("" +
                "9999999 9" +
                "9999999 9" +
                "9999999 9" +
                "999999123" +
                "999999456" +
                "      798" +
                "9999999 9" +
                "9999999 9" +
                "9999999 9");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(5,7,"1");
        assert board.checkNeighbors(5,7,"2");
        assert board.checkNeighbors(5,7,"3");
        assert board.checkNeighbors(5,7,"4");
        assert board.checkNeighbors(5,7,"5");
        assert board.checkNeighbors(5,7,"6");
        assert board.checkNeighbors(5,7,"7");
        assert board.checkNeighbors(5,7,"8");
        assert !board.checkNeighbors(5,7,"9");
    }

    @Test
    public void checkNeighbors_InBlock7_Test() {
        board = new Board().setBoard("" +
                "99 999999" +
                "99 999999" +
                "99 999999" +
                "99 999999" +
                "99 999999" +
                "99 999999" +
                "129      " +
                "345999999" +
                "678999999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(6,2,"1");
        assert board.checkNeighbors(6,2,"2");
        assert board.checkNeighbors(6,2,"3");
        assert board.checkNeighbors(6,2,"4");
        assert board.checkNeighbors(6,2,"5");
        assert board.checkNeighbors(6,2,"6");
        assert board.checkNeighbors(6,2,"7");
        assert board.checkNeighbors(6,2,"8");
        assert !board.checkNeighbors(6,2,"9");
    }

    @Test
    public void checkNeighbors_InBlock8_Test() {
        board = new Board().setBoard("" +
                "999 99999" +
                "999 99999" +
                "999 99999" +
                "999 99999" +
                "999 99999" +
                "999 99999" +
                "999123999" +
                "   945   " +
                "999678999");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(7,3,"1");
        assert board.checkNeighbors(7,3,"2");
        assert board.checkNeighbors(7,3,"3");
        assert board.checkNeighbors(7,3,"4");
        assert board.checkNeighbors(7,3,"5");
        assert board.checkNeighbors(7,3,"6");
        assert board.checkNeighbors(7,3,"7");
        assert board.checkNeighbors(7,3,"8");
        assert !board.checkNeighbors(7,3,"9");
    }

    @Test
    public void checkNeighbors_InBlock9_Test() {
        board = new Board().setBoard("" +
                "999999 99" +
                "999999 99" +
                "999999 99" +
                "999999 99" +
                "999999 99" +
                "999999 99" +
                "999999123" +
                "999999456" +
                "      978");
        LOGGER.debug(board.toString());
        assert board.checkNeighbors(8,6,"1");
        assert board.checkNeighbors(8,6,"2");
        assert board.checkNeighbors(8,6,"3");
        assert board.checkNeighbors(8,6,"4");
        assert board.checkNeighbors(8,6,"5");
        assert board.checkNeighbors(8,6,"6");
        assert board.checkNeighbors(8,6,"7");
        assert board.checkNeighbors(8,6,"8");
        assert !board.checkNeighbors(8,6,"9");
    }

    @Test
    public void checkNeighbors_NoNeighborsTest() {
        board = new Board().setBoard("" +
                "4444 4444" +
                "4444 4444" +
                "4444 4444" +
                "444   444" +
                "    4    " +
                "444   444" +
                "4444 4444" +
                "4444 4444" +
                "4444 4444");
        LOGGER.debug(board.toString());
        assert !board.checkNeighbors(4,4,"4");
    }

    @Test
    public void testToBoardString() {
        String boardString =
                "123456789234567891345678912456789123567891234678912345789123456891234567912345678";
        board = new Board().setBoard(boardString);
        assert boardString.equals(board.getBoardString());
    }

    @Test
    public void boardBuilderTest() {
        System.out.println(new BoardBuilder().fillBoard().build().toString());
    }
}
