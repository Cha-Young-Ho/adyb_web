package cyh.adyb.web.Controller;

import cyh.adyb.domain.User;
import cyh.adyb.service.SignUpService;
import cyh.adyb.web.session.SessionConst;
import cyh.adyb.web.validator.UserSignUpLoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignUpContoller {


    @Autowired
    private final SignUpService signUpService;

    @GetMapping("/signup")
    public String signup(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)User user, Model model){

        if(user != null){
            return "redirect:/";
        }
        return "/signup";
    }

    @PostMapping("/signup")
    public String signupForm(@Validated @ModelAttribute("formUser") UserSignUpLoginForm formUser, BindingResult bindingResult, Model model){

        //공백 및 오류형태로 입력시
        if(bindingResult.hasErrors()){
            return "/signup";
        }

        // sign up form 형태로 받은 user정보 파싱
        User user2 = new User();
        user2.setUserId(formUser.getUserId());
        user2.setPassword(formUser.getPassword());

        return  signUpService.signup(user2);
    }

};