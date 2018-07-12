package games.sudoku.services.game.repos;

import games.sudoku.services.game.entities.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<GameEntity,Integer>, GameRepositoryCustom {
}
