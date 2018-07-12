package games.sudoku.services.game;

import games.sudoku.domain.Game;

import java.util.List;

public interface GameService {
    void saveGame(Game game);
    Game findGame(Integer id);
    boolean exists(Integer id);
    List<Game> getAllGames();
    Integer getGameCount();
    void deleteGame(Integer id);
    void deleteAllGames();
    Game getNextGame();
}
