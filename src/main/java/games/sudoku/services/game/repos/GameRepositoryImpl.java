package games.sudoku.services.game.repos;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GameRepositoryImpl implements GameRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

}
