package games.sudoku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/board")
    public String sayHello(@RequestParam("t1") String t1, @RequestParam("t2") String t2, Model model) {
        model.addAttribute("result", Integer.parseInt(t1) + Integer.parseInt(t2));
        return "board";
    }
}