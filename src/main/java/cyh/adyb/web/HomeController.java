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

        if(user == null){
            return "home";
        }

        model.addAttribute("user", user);
        return "loginhome";
    }
};