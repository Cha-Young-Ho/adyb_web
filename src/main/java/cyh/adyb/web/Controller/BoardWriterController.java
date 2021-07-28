package cyh.adyb.web.Controller;

import cyh.adyb.domain.Board;
import cyh.adyb.domain.User;
import cyh.adyb.service.BoardWriteService;
import cyh.adyb.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardWriterController {

    private final BoardWriteService boardWriteService;
    @GetMapping("/board_write")
    public String BoardWriter(
            @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                    User user, Model model
    ){
        addUser(user, model);
        return "board_write";
    }

    @PostMapping("/board_write")
    public String BoardWriter(@ModelAttribute Board board, @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
            User user) throws IOException {

        boardWriteService.write(board, user);
        return "redirect:/board";

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