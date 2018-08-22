package games.sudoku.services.game;

import games.sudoku.model.Game;

import java.util.List;

public interface GameService {
    void save(Game game);
    Game find(Integer id);
    boolean exists(Integer id);
    List<Game> getAll();
    Integer count();
    void delete(Integer id);
    void deleteAll();
    Game next();
}
