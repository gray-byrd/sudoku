package games.sudoku.domain;

public class GameBuilder {

    private Integer id = 0;
    private String gameString = "";
    private String solvString = "";

    public Game build() {
        return new Game(id, gameString, solvString);
    }

    public GameBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public GameBuilder setGameBoard(String gameString) {
        this.gameString = gameString;
        return this;
    }

    public GameBuilder setSolvBoard(String solvString) {
        this.solvString = solvString;
        return this;
    }
}
