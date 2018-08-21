package games.sudoku.domain;

public class UserBuilder {

    private Integer id;
    private String userName;
    private String password;

    public User build() {
        return new User(id, userName, password);
    }

    public UserBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
}
