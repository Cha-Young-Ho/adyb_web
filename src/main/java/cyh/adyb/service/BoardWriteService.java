package cyh.adyb.service;

import cyh.adyb.domain.Board;
import cyh.adyb.domain.User;
import cyh.adyb.repository.BoardRepository;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardWriteService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    public void write(Board board, User user){

        User findUser = userRepository.findByUserId(user.getUserId());
        board.setUser(findUser);
        boardRepository.save(board);

    }
};