package games.sudoku.services.game;

import games.sudoku.domain.BoardConstants;
import games.sudoku.domain.Game;
import games.sudoku.domain.GameBuilder;
import games.sudoku.services.game.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameServiceTest {

    @Autowired
    private GameService service;

    @Test
    public void saveGameTest() {
        service.saveGame(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString).build());
        assert service.getGameCount() > 2;
        service.deleteGame(service.getNextGame().getId());
    }

    @Test
    public void findGameTest() {
        assert BoardConstants.gameString.equals(service.findGame(
                service.getNextGame().getId()).getGameBoard().getBoardString());
    }

    @Test
    public void existsTest() {
        assert service.exists(service.getNextGame().getId());
    }

    @Test
    public void getAllGamesTest() {
        assert service.getAllGames().size() == 2;
    }

    @Test
    public void getGameCountTest() {
        assert service.getGameCount() == 2;
    }

    @Test
    public void deleteGameTest() {
        Integer id = service.getNextGame().getId();
        service.deleteGame(id);
        assert !service.exists(id);
        service.saveGame(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString).build());
    }

    @Test
    public void deleteAllGamesTest() {
        service.deleteAllGames();
        assert service.getGameCount() == 0;
        GameBuilder gameBuilder = new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString);
        service.saveGame(gameBuilder.build());
        service.saveGame(gameBuilder.build());
    }

    @Test
    public void getNextGameTest() {
        assert service.getNextGame() != null;
    }
}
