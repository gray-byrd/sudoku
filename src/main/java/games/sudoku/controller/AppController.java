package games.sudoku.controller;

import games.sudoku.beans.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @RequestMapping("/")
    public String welcome() {
        return "app.welcome";
    }

    @RequestMapping("/play")
    public ModelAndView drawBoard() {
        String boardString = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
        Board board = new Board(boardString);
        ModelAndView modelAndView = new ModelAndView("app.play");
        modelAndView.addObject("board", board.getGameBoard());
        return modelAndView;
    }

    @RequestMapping("/win")
    public String win() {
        return "app.win";
    }
}