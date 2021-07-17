package cyh.adyb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardContller {

    @GetMapping("/board")
    public String board(){

        return "board";
    }
};