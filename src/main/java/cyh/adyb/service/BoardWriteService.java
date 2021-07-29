package cyh.adyb.service;

import cyh.adyb.component.FileHandler;
import cyh.adyb.domain.Board;
import cyh.adyb.domain.User;
import cyh.adyb.domain.UserFile;
import cyh.adyb.repository.BoardRepository;
import cyh.adyb.repository.UserFileRepository;
import cyh.adyb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardWriteService {


    private final FileHandler fileHandler;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final UserFileRepository userFileRepository;
    public void write(Board board, User user) throws IOException {



        User findUser = userRepository.findByUserId(user.getUserId());

        board.setUser(findUser);

        boardRepository.save(board);

    }
};