package games.sudoku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @RequestMapping("/")
    public String welcome() {
        return "app.welcome";
    }

    @RequestMapping("/play")
    public String play() {
        return "app.play";
    }

    @RequestMapping("/win")
    public String win(@RequestParam("a1") String a1, @RequestParam("a2") String a2, Model model) {
        model.addAttribute("result", Integer.parseInt(a1) + Integer.parseInt(a2));
        return "app.win";
    }
}