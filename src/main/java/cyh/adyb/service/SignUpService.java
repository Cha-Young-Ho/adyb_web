package cyh.adyb.service;


import cyh.adyb.domain.User;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignUpService {

    @Autowired
    private final UserRepository userRepository;

    /**
     * 회원가입
     */
    public String signup(User user){


        //id 중복 시
        if(userRepository.findByUserId(user.getUserId()) != null){
            return "signup";
        }

        //id 중복이 아닐 시
        userRepository.save(user);
        return "redirect:/";
    }
};