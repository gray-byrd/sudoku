package games.sudoku.domain;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String userName;
    private String password;

    User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
