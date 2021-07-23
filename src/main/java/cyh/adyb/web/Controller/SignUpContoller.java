package cyh.adyb.web.Controller;

import cyh.adyb.domain.User;
import cyh.adyb.service.SignUpService;
import cyh.adyb.web.session.SessionConst;
import cyh.adyb.web.validator.UserSignUpForm;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SignUpContoller {


    @Autowired
    private final SignUpService signUpService;

    @GetMapping("/signup")
    public String signup( @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                                      User user, Model model){

        if(user != null){
            model.addAttribute("user", new User());
            return "redirect:/";
        }
        model.addAttribute("user", new User());
        return "/signup";
    }

    @PostMapping("/signup")
    public String signupForm(@Validated @ModelAttribute("user") UserSignUpForm user, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        log.info("userid ={}", user.getUserId());
        if(bindingResult.hasErrors()){
            log.info("sign up errors ={}", bindingResult);

            return "/signup";
        }

        User user2 = new User();
        user2.setUserId(user.getUserId());
        user2.setPassword(user.getPassword());

        return  signUpService.signup(user2);
    }

};