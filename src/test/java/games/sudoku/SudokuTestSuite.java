package games.sudoku;

import games.sudoku.model.BoardTest;
import games.sudoku.model.GameTest;
import games.sudoku.services.game.repos.GameRepositoryTest;
import games.sudoku.services.game.GameServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({GameRepositoryTest.class, GameServiceTest.class, BoardTest.class, GameTest.class})
public class SudokuTestSuite {
}
