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
public class UserPageService {

    @Autowired
    private final UserRepository userRepository;

    public List<Board> userPageBoard(String userId){

        User findUser = userRepository.findByUserId(userId);
        List<Board> myBoardList = findUser.getBoardList();

        return myBoardList;
    }

};