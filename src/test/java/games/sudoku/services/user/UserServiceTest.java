package games.sudoku.services.user;

import games.sudoku.model.UserBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Before
    public void setUp() {
        service.save(new UserBuilder()
                .setEmail("email")
                .setPassword("password")
                .build());
    }

    @After
    public void tearDown() {
        service.deleteAll();
    }

    @Test
    public void saveTest() {
        assert service.count() > 0;
    }

    @Test
    public void findTest() {
        assert "email".equals(service.find(
                service.next().getId()).getEmail());
    }

    @Test
    public void existsTest() {
        assert service.exists(service.next().getId());
    }

    @Test
    public void getAllTest() {
        service.save(new UserBuilder()
                .setEmail("email2")
                .setPassword("password")
                .build());
        assert service.getAll().size() == service.count();
    }

    @Test
    public void countTest() {
        assert service.count() == 1;
    }

    @Test
    public void deleteTest() {
        service.delete(service.next().getId());
        assert service.count() == 0;
    }

    @Test
    public void deleteAllTest() {
        service.save(new UserBuilder()
                .setEmail("email2")
                .setPassword("password")
                .build());
        service.deleteAll();
        assert service.count() == 0;
    }

    @Test
    public void nextTest() {
        assert service.exists(service.next().getId());
    }

    @Test
    public void findByEmailTest() {
        assert service.exists(service.findByEmail("email").getId());
    }
}
