package games.sudoku.controller;

import games.sudoku.model.Game;
import games.sudoku.services.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
        game = service.next();
        return buildModel("game.tile");
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ModelAndView drawGame() {
        return buildModel("game.tile");
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
        return buildModel((game.isGameWon()) ? "win.tile" : "game.tile");
    }

    @RequestMapping(value = "/win", method = RequestMethod.GET)
    public ModelAndView showWin() {
        return new ModelAndView("win.tile");
    }

    private ModelAndView buildModel(String tile) {
        ModelAndView modelAndView = new ModelAndView(tile);
        modelAndView.addObject("board", game.getGameBoard().getBoard());
        modelAndView.addObject("ctrls", game.getCtrls());
        modelAndView.addObject("selected", game.getGameBoard().getSelected());
        return modelAndView;
    }
}