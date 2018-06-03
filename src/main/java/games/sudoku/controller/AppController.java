package games.sudoku.controller;

import games.sudoku.beans.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    private Game game;

    @RequestMapping("/")
    public String welcome() {
        return "welcome.tile";
    }

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ModelAndView drawGame() {
        game = new Game();
        ModelAndView modelAndView = new ModelAndView("game.tile");
        modelAndView.addObject("board", game.getGameBoard().getBoard());
        modelAndView.addObject("ctrls", game.getCtrls());
        return modelAndView;
    }

    @RequestMapping(value = "/play", method = RequestMethod.GET)
    public ModelAndView makePlay(@RequestParam(value = "row")String row,
                                 @RequestParam(value = "col")String col,
                                 @RequestParam(value = "value")String value) {
        if (game.getSolvBoard().getValue(Integer.parseInt(row), Integer.parseInt(col)).equals(value)) {
            game.getGameBoard().setValue(Integer.parseInt(row), Integer.parseInt(col), value);
        }
        if (!game.getGameBoard().contains(" ")){
            ModelAndView modelAndView = new ModelAndView("win.tile");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("game.tile");
        modelAndView.addObject("board", game.getGameBoard().getBoard());
        modelAndView.addObject("ctrls", game.getCtrls());
        return modelAndView;
    }
}