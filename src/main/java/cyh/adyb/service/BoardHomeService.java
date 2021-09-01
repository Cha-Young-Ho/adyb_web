package cyh.adyb.service;

import cyh.adyb.domain.Board;
import cyh.adyb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardHomeService {
    private final BoardRepository boardRepository;
    public List<Board> boardHomeService(){

        List<Board> boardList = boardRepository.findAll();

        for (int i = 0; i < boardList.size(); i++) {
            log.info("i = {}", i);
            log.info("board title = {}",boardList.get(i).getTitle());
        }
        return boardList;
    }
};