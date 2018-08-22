package games.sudoku.model;

public class UserBuilder {

    private Integer id;
    private String email;
    private String password;

    public User build() {
        return new User(id, email, password);
    }

    public UserBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
}
