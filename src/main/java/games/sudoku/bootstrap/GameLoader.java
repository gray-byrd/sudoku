package games.sudoku.bootstrap;

import games.sudoku.domain.BoardConstants;
import games.sudoku.domain.GameBuilder;
import games.sudoku.services.game.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class GameLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger LOGGER = LoggerFactory.getLogger(GameLoader.class);

    private GameService service;

    @Autowired
    public void setGameService(GameService service) {
        this.service = service;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        service.saveGame(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString)
                .build());
        LOGGER.info("Saved Game 1");

        service.saveGame(new GameBuilder()
                .setGameBoard(BoardConstants.gameString)
                .setSolvBoard(BoardConstants.solvString)
                .build());
        LOGGER.info("Saved Game 2");
    }
}
