package cyh.adyb.web.Controller;

import cyh.adyb.domain.User;
import cyh.adyb.web.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

};