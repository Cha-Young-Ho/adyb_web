package cyh.adyb.web.Controller;

import cyh.adyb.domain.User;
import cyh.adyb.service.LoginService;
import cyh.adyb.web.session.SessionConst;
import cyh.adyb.web.validator.UserSignUpLoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    @Autowired
    private final LoginService loginService;

    @GetMapping("/login")
    public String login(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                                    User user, Model model) {
        model.addAttribute("user", new User());
        if(user != null){
            return "redirect:/";
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginId(@ModelAttribute User user, HttpServletRequest request, Model model) {

        
        //로그인 성공
        if(loginService.login(user)){
            // 세션 생성
            HttpSession session = request.getSession();
            // 세션 설정
            session.setAttribute(SessionConst.LOGIN_USER, user);
            return "redirect:/";
        }
        
        //로그인 실패
        return "login";
    }

};