package cyh.adyb.web.Controller;


import cyh.adyb.domain.User;
import cyh.adyb.service.MyPageService;
import cyh.adyb.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    @Autowired
    private final MyPageService myPageService;


    @GetMapping("/mypage")
    public String getMyPage(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                    User user, Model model
    ){

        model.addAttribute("boardList", myPageService.myPageBoard(user));
        return "/mypage";
    }
};