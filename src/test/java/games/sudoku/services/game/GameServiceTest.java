package games.sudoku.services.game;

import games.sudoku.model.BoardConstants;
import games.sudoku.model.GameBuilder;
import org.junit.After;
import org.junit.Before;
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

    @Before
    public void setUp() {
        service.save(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString)
                .build());

        service.save(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString)
                .build());
    }

    @After
    public void tearDown() {
        service.deleteAll();
    }

    @Test
    public void saveGameTest() {
        service.save(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString).build());
        assert service.count() > 2;
        service.delete(service.next().getId());
    }

    @Test
    public void findGameTest() {
        assert BoardConstants.gameString.equals(service.find(
                service.next().getId()).getGameBoard().getBoardString());
    }

    @Test
    public void existsTest() {
        assert service.exists(service.next().getId());
    }

    @Test
    public void getAllGamesTest() {
        assert service.getAll().size() == 2;
    }

    @Test
    public void getGameCountTest() {
        assert service.count() == 2;
    }

    @Test
    public void deleteGameTest() {
        Integer id = service.next().getId();
        service.delete(id);
        assert !service.exists(id);
        service.save(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString).build());
    }

    @Test
    public void deleteAllGamesTest() {
        service.deleteAll();
        assert service.count() == 0;
        GameBuilder gameBuilder = new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString);
        service.save(gameBuilder.build());
        service.save(gameBuilder.build());
    }

    @Test
    public void getNextGameTest() {
        assert service.next() != null;
    }
}
