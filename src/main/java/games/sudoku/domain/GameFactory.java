package games.sudoku.domain;

public class GameFactory {

    public static Game generateGame() {
        return new Game(BoardConstants.gameString, BoardConstants.solvString);
    }
}
