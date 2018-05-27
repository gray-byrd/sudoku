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

    @RequestMapping("/game")
    public ModelAndView playGame() {
        if (game == null) { game = new Game(); }
        ModelAndView modelAndView = new ModelAndView("game.tile");
        modelAndView.addObject("board", game.getGameBoard().getBoard());
        modelAndView.addObject("ctrls", game.getCtrls());
        return modelAndView;
    }

    @RequestMapping("/win")
    public String win() {
        return "win.tile";
    }
}