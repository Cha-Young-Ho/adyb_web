package cyh.adyb.web;

import cyh.adyb.domain.User;
import cyh.adyb.web.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                    User user, Model model
    ){

        addUser(user, model);
        return "home";
    }

    public void addUser(User user, Model model){
        if(user == null) {
            model.addAttribute("user", null);
            return;
        }

        model.addAttribute("user", user);

        return;
    }
};