package cyh.adyb.service;


import cyh.adyb.domain.User;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    @Autowired
    private final UserRepository userRepository;

    public void signup(User user){
        userRepository.save(user);
    }
};