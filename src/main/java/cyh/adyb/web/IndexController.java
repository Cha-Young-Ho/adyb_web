package cyh.adyb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/aa")
    public String index(){

        return "sample";
    }

};