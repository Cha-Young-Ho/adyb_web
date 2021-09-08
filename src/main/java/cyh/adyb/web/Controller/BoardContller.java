package cyh.adyb.web.Controller;


import cyh.adyb.service.BoardHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardContller {

    private final BoardHomeService boardHomeService;
    @GetMapping("/board")
    public String board(Model model){
        model.addAttribute("boards", boardHomeService.boardHomeService());

        return "board";
    }

};