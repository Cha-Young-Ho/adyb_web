package cyh.adyb.web.Controller;

import cyh.adyb.domain.Mail;
import cyh.adyb.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class MailController {

    private final MailService mailService;
    @GetMapping("/email")
    public String getEmail(){

        return "email";
    }

    @PostMapping("/contact/email/dosend")
    public String doSend(@ModelAttribute Mail mail){

        log.info("mail title = {}", mail.getTitle());
        log.info("mail phoneNumber = {}", mail.getPhoneNumber());
        log.info("mail message = {}", mail.getMessage());
        log.info("mail address = {}", mail.getAddress());

        mailService.mailSend(mail);

        return "redirect:/";
    }

};