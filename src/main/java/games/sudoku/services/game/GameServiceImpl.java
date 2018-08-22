package games.sudoku.services.game;

import games.sudoku.model.Game;
import games.sudoku.model.GameBuilder;
import games.sudoku.services.game.entities.GameEntity;
import games.sudoku.services.game.repos.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service("GameService")
public class GameServiceImpl implements GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameServiceImpl.class);

    private GameRepository repo;

    @Autowired
    public void setGameRepository(GameRepository repo) {
        this.repo = repo;
    }

    @Override
    public void save(Game game) {
        LOGGER.debug("Calling game.save...");
        Instant start = Instant.now();
        try {
            GameEntity e = new GameEntity();
            e.setId(game.getId());
            e.setGameBoard(game.getGameBoard().getBoardString());
            e.setSolvBoard(game.getSolvBoard().getBoardString());
            repo.save(e);
            LOGGER.debug("Game Saved in " +
                    Duration.between(start, Instant.now()).toMillis());
        } catch (Exception e) {
            LOGGER.error("ERROR Saving Game...", e);
        }
    }

    @Override
    public Game find(Integer id) {
        LOGGER.debug("Calling game.find...");
        try {
            return convert(repo.findOne(id));
        } catch (Exception e) {
            LOGGER.error("ERROR Finding Game...", e);
            return new GameBuilder().build();
        }
    }

    @Override
    public boolean exists(Integer id) {
        LOGGER.debug("Calling game.exists...");
        try {
            return repo.exists(id);
        } catch (Exception e) {
            LOGGER.error("ERROR Calling Exists...", e);
            return false;
        }
    }

    @Override
    public List<Game> getAll() {
        LOGGER.debug("Calling game.gatAllGames...");
        List<Game> games = new ArrayList<>();
        try {
            repo.findAll().forEach(e -> games.add(convert(e)));
            LOGGER.debug("Games Found");
        } catch (Exception e) {
            LOGGER.error("ERROR Finding All Game...", e);
        }
        return games;
    }

    @Override
    public Integer count() {
        LOGGER.debug("Calling game.count...");
        try {
            return (int) repo.count();
        } catch (Exception e) {
            LOGGER.error("ERROR Counting Games...", e);
            return 0;
        }
    }

    @Override
    public void delete(Integer id) {
        LOGGER.debug("Calling game.delete...");
        try {
            repo.delete(id);
            LOGGER.debug("Game Deleted");
        } catch (Exception e) {
            LOGGER.error("ERROR Deleting Game...", e);
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("Calling game.deleteAll...");
        try {
            repo.deleteAll();
            LOGGER.debug("All Games Deleted");
        } catch (Exception e) {
            LOGGER.error("ERROR Deleting Games...", e);
        }
    }

    @Override
    public Game next() {
        LOGGER.debug("Calling game.next...");
        try {
            return convert(repo.findAll().iterator().next());
        } catch (Exception e) {
            LOGGER.error("ERROR finding game...");
            return new GameBuilder().build();
        }
    }

    private Game convert(GameEntity game) {
        return new Game(game.getId(), game.getGameBoard(), game.getSolvBoard());
    }
}