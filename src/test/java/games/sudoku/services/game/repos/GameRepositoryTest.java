package games.sudoku.services.game.repos;

import games.sudoku.domain.BoardConstants;
import games.sudoku.services.game.entities.GameEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameRepositoryTest {

    private GameRepository repo;

    @Autowired
    public void setGameRepository(GameRepository repo) {
        this.repo = repo;
    }

    @Test
    public void saveEntityTest() {
        GameEntity game = new GameEntity();
        game.setGameBoard(BoardConstants.gameString);
        game.setSolvBoard(BoardConstants.solvString);
        repo.save(game);
        assert repo.count() == 3;
        repo.delete(repo.findAll().iterator().next().getId());
    }

    @Test
    public void findEntityTest() {
        assert BoardConstants.gameString.equals(repo.findOne(
                repo.findAll().iterator().next().getId()).getGameBoard());
    }

    @Test
    public void entityExistsTest() {
        assert repo.exists(repo.findAll().iterator().next().getId());
    }

    @Test
    public void findAllEntitiesTest() {
        List<GameEntity> games = new ArrayList<>();
        repo.findAll().forEach(games::add);
        assert games.size() == 2;
    }

    @Test
    public void entityCountTest() {
        assert repo.count() == 2;
    }

    @Test
    public void deleteEntityTest() {
        int id = repo.findAll().iterator().next().getId();
        repo.delete(id);
        assert !repo.exists(id);
        GameEntity game = new GameEntity();
        game.setGameBoard(BoardConstants.gameString);
        game.setSolvBoard(BoardConstants.solvString);
        repo.save(game);
    }

    @Test
    public void deleteAllEntities() {
        repo.deleteAll();
        assert repo.count() == 0;
        GameEntity e1 = new GameEntity();
        e1.setGameBoard(BoardConstants.gameString);
        e1.setSolvBoard(BoardConstants.solvString);
        repo.save(e1);
        GameEntity e2 = new GameEntity();
        e2.setGameBoard(BoardConstants.gameString);
        e2.setSolvBoard(BoardConstants.solvString);
        repo.save(e2);
    }
}
