package cyh.adyb.service;

import cyh.adyb.domain.User;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    @Autowired
    private final UserRepository userRepository;

    public boolean login(User user) {

        User findUser = userRepository.findByUserId(user.getUserId());

        if(findUser == null){
            return false;

        }

        if(!findUser.getPassword().equals(user.getPassword())){
            return false;
        }
        return true;

    }

};
////////////필터에서 세션 넣어라!!!!!!!!!!!!!