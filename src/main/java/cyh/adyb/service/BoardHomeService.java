package cyh.adyb.service;

import cyh.adyb.domain.Board;
import cyh.adyb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardHomeService {
    private final BoardRepository boardRepository;
    public List<Board> boardHomeService(){

        List<Board> boardList = boardRepository.findAll();

        return boardList;
    }
};