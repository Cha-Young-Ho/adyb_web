package cyh.adyb.service;

import cyh.adyb.domain.User;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    @Autowired
    private final UserRepository userRepository;


    public String login(User user){

        log.info("user id ={}", user.getId());
        log.info("user password = {}", user.getPassword());
        List<User> lis = userRepository.finduser(user.getId(), user.getPassword());

        log.info("finded user = {}", lis.get(0).getId());

        return "redirect:/";

    }



};