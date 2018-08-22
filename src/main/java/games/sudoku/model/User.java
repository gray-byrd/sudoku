package games.sudoku.model;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String email;
    private String password;

    User() {}

    User(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
