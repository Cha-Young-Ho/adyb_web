package cyh.adyb.web.Controller;


import cyh.adyb.service.UserPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserPageController {

    private final UserPageService userPageService;

    @GetMapping("/userpage")
    public String getUserProfile(@RequestParam String id, Model model){
        model.addAttribute("boardList", userPageService.userPageBoard(id));
        log.info("받아온 쿼리파라미터 = {}", id);
        return "/userpage";
    }
};