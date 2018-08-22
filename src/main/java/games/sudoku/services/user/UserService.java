package games.sudoku.services.user;

import games.sudoku.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User find(Integer id);
    boolean exists(Integer id);
    List<User> getAll();
    Integer count();
    void delete(Integer id);
    void deleteAll();
    User next();
    User findByEmail(String email);
}
