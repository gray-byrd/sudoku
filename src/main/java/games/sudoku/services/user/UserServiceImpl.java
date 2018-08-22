package games.sudoku.services.user;

import games.sudoku.model.User;
import games.sudoku.model.UserBuilder;
import games.sudoku.services.user.entities.UserEntity;
import games.sudoku.services.user.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository repo;

    @Autowired
    public void setUserRepository(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public void save(User user) {
        LOGGER.debug("Calling user.save...");
        Instant start = Instant.now();
        try {
            repo.save(convertObject(user));
            LOGGER.debug("User saved in " +
                    Duration.between(start, Instant.now()).toMillis());
        } catch (Exception e) {
            LOGGER.error("ERROR saving user...", e);
        }
    }

    @Override
    public User find(Integer id) {
        LOGGER.debug("Calling user.find...");
        Instant start = Instant.now();
        User user = new UserBuilder().build();
        try {
            user = convertEntity(repo.findOne(id));
            LOGGER.debug("User found in " +
                    Duration.between(start, Instant.now()).toMillis());
            return user;
        } catch (Exception e) {
            LOGGER.error("ERROR finding user...", e);
            return user;
        }
    }

    @Override
    public boolean exists(Integer id) {
        LOGGER.debug("Calling user.exists...");
        Instant start = Instant.now();
        boolean exists = false;
        try {
            exists = repo.exists(id);
            LOGGER.debug("User found in " +
                    Duration.between(start, Instant.now()).toMillis());
            return exists;
        } catch (Exception e) {
            LOGGER.error("ERROR finding user...", e);
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        LOGGER.debug("Calling user.find...");
        Instant start = Instant.now();
        List<User> users = new ArrayList<>();
        try {
            repo.findAll().forEach(e -> users.add(convertEntity(e)));
            LOGGER.debug("User found in " +
                    Duration.between(start, Instant.now()).toMillis());
            return users;
        } catch (Exception e) {
            LOGGER.error("ERROR finding user...", e);
            return users;
        }
    }

    @Override
    public Integer count() {
        LOGGER.debug("Calling user.count...");
        Instant start = Instant.now();
        Integer count;
        try {
            count = (int) repo.count();
            LOGGER.debug("User found in " +
                    Duration.between(start, Instant.now()).toMillis());
            return count;
        } catch (Exception e) {
            LOGGER.error("ERROR Counting Users...", e);
            return 0;
        }
    }

    @Override
    public void delete(Integer id) {
        LOGGER.debug("Calling user.delete...");
        Instant start = Instant.now();
        try {
            repo.delete(id);
            LOGGER.debug("User deleted in " +
                    Duration.between(start, Instant.now()).toMillis());
        } catch (Exception e) {
            LOGGER.error("ERROR Deleting User...", e);
        }
    }

    @Override
    public void deleteAll() {
        LOGGER.debug("Calling user.deleteAll...");
        Instant start = Instant.now();
        try {
            repo.deleteAll();
            LOGGER.debug("Users deleted in " +
                    Duration.between(start, Instant.now()).toMillis());
        } catch (Exception e) {
            LOGGER.error("ERROR Deleting Users...", e);
        }
    }

    @Override
    public User next() {
        LOGGER.debug("Calling user.find...");
        Instant start = Instant.now();
        User user = new UserBuilder().build();
        try {
            user = convertEntity(repo.findAll().iterator().next());
            LOGGER.debug("User found in " +
                    Duration.between(start, Instant.now()).toMillis());
            return user;
        } catch (Exception e) {
            LOGGER.error("ERROR finding user...", e);
            return user;
        }
    }

    @Override
    public User findByEmail(String email) {
        Instant start = Instant.now();
        User user = new UserBuilder().build();
        LOGGER.debug("Looking for user...");
        try {
            user = convertEntity(repo.findByEmail(email));
            LOGGER.debug("User found in " +
                    Duration.between(start, Instant.now()).toMillis());
            return user;
        } catch (Exception e) {
            LOGGER.error("ERROR saving user...", e);
            return user;
        }
    }

    private User convertEntity(UserEntity entity) {
        return new UserBuilder()
                .setId(entity.getId())
                .setEmail(entity.getEmail())
                .setPassword(entity.getPassword())
                .build();
    }

    private UserEntity convertObject(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        return entity;
    }
}
