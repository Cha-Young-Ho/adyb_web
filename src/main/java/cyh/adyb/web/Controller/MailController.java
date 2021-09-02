package cyh.adyb.web.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MailController {

    @GetMapping("/email")
    public String getEmail(){

        return "email";
    }


};