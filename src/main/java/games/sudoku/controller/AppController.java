package games.sudoku.controller;

import games.sudoku.domain.Game;
import games.sudoku.services.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    private final GameService service;
    private Game game;

    @Autowired
    public AppController(GameService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome.tile";
    }

    @RequestMapping(value = "/newgame", method = RequestMethod.GET)
    public ModelAndView startNewGame() {
        game = service.getNextGame();
        return new ModelAndView("redirect:/game");
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ModelAndView drawGame() {
        ModelAndView modelAndView = new ModelAndView("game.tile");
        modelAndView.addObject("board", game.getGameBoard().getBoard());
        modelAndView.addObject("ctrls", game.getCtrls());
        modelAndView.addObject("selected", game.getGameBoard().getSelected());
        return modelAndView;
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public ModelAndView makePlay(@RequestParam(value = "row")String row,
                                 @RequestParam(value = "col")String col,
                                 @RequestParam(value = "value")String value) {
        if (game.getSolvBoard().getValue(Integer.parseInt(row), Integer.parseInt(col)).equals(value)) {
            game.getGameBoard().setValue(Integer.parseInt(row), Integer.parseInt(col), value);
        } else {
            game.getGameBoard().setSelected("");
        }
        return new ModelAndView((game.isGameWon()) ? "redirect:/win" : "redirect:/game");
    }

    @RequestMapping(value = "/win", method = RequestMethod.GET)
    public ModelAndView showWin() {
        return new ModelAndView("win.tile");
    }
}