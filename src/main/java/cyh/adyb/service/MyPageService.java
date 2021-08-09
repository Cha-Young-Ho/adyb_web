package cyh.adyb.service;

import cyh.adyb.domain.Board;
import cyh.adyb.domain.User;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {

    @Autowired
    private final UserRepository userRepository;

    public List<Board> myPageBoard(User user){

        User findUser = userRepository.findByUserId(user.getUserId());
        List<Board> myBoardList = findUser.getBoardList();

        return myBoardList;
    }

};