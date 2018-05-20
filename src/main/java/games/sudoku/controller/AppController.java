package games.sudoku.controller;

import games.sudoku.beans.Game;
import games.sudoku.enums.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    private Game game;

    @RequestMapping("/")
    public String welcome() {
        return "app.welcome";
    }

    @RequestMapping("/play")
    public ModelAndView drawBoard() {
        if (game == null) { game = new Game(); }
        ModelAndView modelAndView = new ModelAndView("app.play");
        modelAndView.addObject("board", game.getGameBoard().getBoard());
        return modelAndView;
    }

    @RequestMapping(value = "/submitmove", method = RequestMethod.POST)
    public Status submitMove(@RequestParam int row, @RequestParam int col, @RequestParam String value) {
        if (value.equals(game.getSolvBoard().getValue(row, col))) {
            game.getGameBoard().setValue(row, col, value);
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }

    @RequestMapping("/win")
    public String win() {
        return "app.win";
    }
}