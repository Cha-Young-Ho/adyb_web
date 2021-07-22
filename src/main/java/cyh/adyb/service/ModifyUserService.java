package cyh.adyb.service;

import cyh.adyb.domain.User;
import cyh.adyb.repository.UserRepository;
import cyh.adyb.web.validator.UserModifyForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModifyUserService {

    private final UserRepository userRepository;

    public boolean modifyUser(UserModifyForm userModifyForm){

       User user = userRepository.findByUserId(userModifyForm.getBeforeId());

       if(user == null){
           return false;
       }
       user.setUserId(userModifyForm.getUserId());
       user.setPassword(userModifyForm.getPassword());

        userRepository.save(user);

        return true;

    }
};