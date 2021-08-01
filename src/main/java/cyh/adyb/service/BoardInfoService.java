package cyh.adyb.service;

import cyh.adyb.domain.Board;
import cyh.adyb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    private final BoardRepository boardRepository;

    public Board findBoard(Long boardId){

        return boardRepository.getById(boardId);
    }

};