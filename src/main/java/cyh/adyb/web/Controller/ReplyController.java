package cyh.adyb.web.Controller;

import cyh.adyb.domain.Reply;
import cyh.adyb.domain.User;
import cyh.adyb.repository.ReplyRepository;
import cyh.adyb.service.ReplyService;
import cyh.adyb.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReplyController {

    @Autowired
    private final ReplyService replyService;

    @PostMapping("/reply_write")
    public String replyWrite(@ModelAttribute Reply reply, Long boardId, @SessionAttribute(SessionConst.LOGIN_USER) User user){

        return replyService.replyWrite(reply, user, boardId);

    }

    @PostMapping("/reply_delete")
    public String replyDelete(@ModelAttribute Reply reply, @SessionAttribute(name = SessionConst.LOGIN_USER, required = false)
            User user){


        return replyService.replyDelete(reply);
    }

};