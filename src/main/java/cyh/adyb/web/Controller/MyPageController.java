package cyh.adyb.web.Controller;


import cyh.adyb.domain.User;
import cyh.adyb.web.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MyPageController {

    @GetMapping("/mypage")
    public String getMyPage(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                    User user, Model model
    ){

        return "/mypage";
    }
};