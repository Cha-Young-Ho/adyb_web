package cyh.adyb.web.Controller;


import cyh.adyb.domain.User;
import cyh.adyb.service.ModifyUserService;
import cyh.adyb.web.validator.UserModifyForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ModifyUserController {

    private final ModifyUserService modifyUserService;

    @GetMapping("/modify")
    public String ModifyUser(Model model){

        model.addAttribute("user", new User());
        return "/modify";
    }

    @PostMapping("/modify")
    public String ModifyUser(@Validated @ModelAttribute UserModifyForm userModifyForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info("errors ={}", bindingResult);
            return "/modify";
        }
        log.info("user form beforeid ={}", userModifyForm.getBeforeId());
        log.info("user form beforepass ={}", userModifyForm.getBeforePassword());
        log.info("user form afterid={}", userModifyForm.getUserId());
        log.info("user form afterpass= {}", userModifyForm.getPassword());

        boolean check = modifyUserService.modifyUser(userModifyForm);

        if(check == false){
            return "/modify";
        }

        return "redirect:/";


    }

};