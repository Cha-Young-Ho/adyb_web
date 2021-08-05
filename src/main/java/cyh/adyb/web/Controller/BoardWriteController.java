package cyh.adyb.web.Controller;

import cyh.adyb.component.FileHandler;
import cyh.adyb.domain.Board;
import cyh.adyb.domain.User;
import cyh.adyb.service.BoardUserFileService;
import cyh.adyb.service.BoardWriteService;
import cyh.adyb.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardWriteController {

    private final BoardWriteService boardWriteService;
    private final FileHandler fileHandler;
    private final BoardUserFileService boardUserFileService;
    @GetMapping("/board_write")
    public String BoardWriter(){
        return "board_write";
    }

    @PostMapping("/board_write")
    public String BoardWriter(@ModelAttribute Board board, @RequestParam(value="imageFiles", required=false) List<MultipartFile> files, @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
            User user) throws IOException {


        boardWriteService.write(board, user);

        log.info("files empty = {}", files.isEmpty());

        if(!(files.isEmpty())) {
            boardUserFileService.userFilelRepository(fileHandler.UserFileUpload(files, user.getUserId()), board);
        }
        return "redirect:/board";

    }


};