package cyh.adyb.web;

import cyh.adyb.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class SignUpContoller {

    @GetMapping("/signup")
    public String signup(){
        return "/signup";
    }

    @PostMapping("/signup")
    public String signupForm(@ModelAttribute User user){

        log.info("id ={}",user.getId());
        log.info("password ={}", user.getPassword());

        return "redirect:/";
    }
};