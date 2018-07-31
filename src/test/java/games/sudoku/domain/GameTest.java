package games.sudoku.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTest {

    @Test
    public void isGameWon_CompleteTest() {
        String boardString =
                "123456789234567891345678912456789123567891234678912345789123456891234567912345678";
        Game game = new GameBuilder().setGameBoard(boardString).setSolvBoard(boardString).build();
        assert game.isGameWon();
    }

    @Test
    public void isGameWon_NotCompleteTest() {
        String boardString =
                "1234567892345678913456789124567891235678912 4678912345789123456891234567912345678";
        Game game = new GameBuilder().setGameBoard(boardString).setSolvBoard(boardString).build();
        assert !game.isGameWon();
    }

    @Test
    public void getCtrls_AllTest() {
        String boardString =
                "                                                                                 ";
        Game game = new GameBuilder().setGameBoard(boardString).setSolvBoard(boardString).build();
        assert "1".equals(game.getCtrls().get(0));
        assert "2".equals(game.getCtrls().get(1));
        assert "3".equals(game.getCtrls().get(2));
        assert "4".equals(game.getCtrls().get(3));
        assert "5".equals(game.getCtrls().get(4));
        assert "6".equals(game.getCtrls().get(5));
        assert "7".equals(game.getCtrls().get(6));
        assert "8".equals(game.getCtrls().get(7));
        assert "9".equals(game.getCtrls().get(8));
    }

    @Test
    public void getCtrls_ClearedTest() {
        String boardString =
                "12345678923456789134567891245678912356789123 678912345789123456891234567912345678";
        Game game = new GameBuilder().setGameBoard(boardString).setSolvBoard(boardString).build();
        assert " ".equals(game.getCtrls().get(0));
        assert " ".equals(game.getCtrls().get(1));
        assert " ".equals(game.getCtrls().get(2));
        assert "4".equals(game.getCtrls().get(3));
        assert " ".equals(game.getCtrls().get(4));
        assert " ".equals(game.getCtrls().get(5));
        assert " ".equals(game.getCtrls().get(6));
        assert " ".equals(game.getCtrls().get(7));
        assert " ".equals(game.getCtrls().get(8));
    }
}
