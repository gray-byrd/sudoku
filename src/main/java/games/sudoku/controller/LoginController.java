package games.sudoku.controller;

import games.sudoku.model.User;
import games.sudoku.model.UserBuilder;
import games.sudoku.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes("email")
public class LoginController {

    private final UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUp() {
        return new ModelAndView("signup.tile", "user", new UserBuilder().build());
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signIn() {
        return new ModelAndView("signin.tile", "user", new UserBuilder().build());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap model, HttpSession session) {
        if (!result.hasErrors()) {
            service.save(user);
            model.addAttribute("email", user.getEmail());
            session.setAttribute("loggedIn", true);
            return new ModelAndView("welcome.tile");
        }
        return new ModelAndView("error.tile");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("user")User loginUser, BindingResult result, ModelMap model, HttpSession session) {
        User user = service.findByEmail(loginUser.getEmail());
        if (!result.hasErrors() && loginUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("email", user.getEmail());
            session.setAttribute("loggedIn", true);
            return new ModelAndView("welcome.tile");
        }
        return new ModelAndView("error.tile");
    }
}
