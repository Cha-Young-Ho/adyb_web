package cyh.adyb.web.Controller;

import cyh.adyb.service.BoardInfoService;
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

    @GetMapping("/board_info")
    public String BoardInfo(){
        return "board_info";
    }



    @PostMapping("/board_info")
    public String BoardInfoPost(Model model, Long boardId){
        log.info("board id == {}", boardId);
        model.addAttribute("board", boardInfoService.findBoard(boardId));
        return "board_info";
    }


};