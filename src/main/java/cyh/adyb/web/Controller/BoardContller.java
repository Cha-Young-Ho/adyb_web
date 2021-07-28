package cyh.adyb.web.Controller;

import cyh.adyb.domain.User;
import cyh.adyb.repository.BoardRepository;
import cyh.adyb.service.BoardHomeService;
import cyh.adyb.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class BoardContller {

    private final BoardHomeService boardHomeService;
    @GetMapping("/board")
    public String board(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                                     User user, Model model){
        addUser(user, model);
        model.addAttribute("boards", boardHomeService.boardHomeService());

        return "board";
    }
    public void addUser(User user, Model model){
        if(user == null) {
            model.addAttribute("user", new User());
            return;
        }
        model.addAttribute("user", user);
        return;
    }
};