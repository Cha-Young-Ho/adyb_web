package cyh.adyb.web.Controller;

import cyh.adyb.domain.User;
import cyh.adyb.service.BoardInfoService;
import cyh.adyb.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoardInfoController {

    private final BoardInfoService boardInfoService;

    @GetMapping("/board_info/{boardId}")
    public String BoardInfo(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                                        User user, Model model
    ){
        addUser(user, model);
        return "board_info";
    }



    @PostMapping("/board_info")
    public String BoardInfoPost(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
                                            User user, Model model, Long boardId){
        addUser(user, model);
        log.info("board id == {}", boardId);
        model.addAttribute("board", boardInfoService.findBoard(boardId));
        return "board_info";
        // form 형식으로 boardid넘긴다음 해당 info로 리턴하는 작업중 form에서 LONG ID하나만 넘기면댐
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