package cyh.adyb.service;


import cyh.adyb.domain.Board;
import cyh.adyb.domain.Reply;
import cyh.adyb.domain.User;
import cyh.adyb.repository.BoardRepository;
import cyh.adyb.repository.ReplyRepository;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    @Autowired
    private final ReplyRepository replyRepository;

    @Autowired
    private final BoardRepository boardRepository;

    @Autowired
    private final UserRepository userRepository;

    public String replyWrite(Reply reply, User user, Long boardId){

        User findUser = userRepository.findByUserId(user.getUserId());
        Optional<Board> findBoard = boardRepository.findById(boardId);

        reply.setBoard(findBoard.get());
        reply.setUser(findUser);
        replyRepository.save(reply);

        return "home";
    }

    public String replyDelete(Reply reply){

        replyRepository.delete(reply);

        return "home";
    }

};