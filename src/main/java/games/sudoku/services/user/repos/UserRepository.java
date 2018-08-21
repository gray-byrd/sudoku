package games.sudoku.services.user.repos;

import games.sudoku.services.user.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUserName(String userName);
}
