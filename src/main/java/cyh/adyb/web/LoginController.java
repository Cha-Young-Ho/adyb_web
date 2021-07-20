package cyh.adyb.web;

import cyh.adyb.domain.User;
import cyh.adyb.service.LoginService;
import cyh.adyb.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    @Autowired
    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginId(@ModelAttribute User user, HttpServletRequest request) {
        if(!loginService.login(user)){
            return "login";
        }

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.LOGIN_USER, user);


        return "redirect:/";
    }

};