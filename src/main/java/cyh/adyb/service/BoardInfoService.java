package cyh.adyb.service;

import cyh.adyb.domain.Board;
import cyh.adyb.domain.User;
import cyh.adyb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardInfoService {

    private final BoardRepository boardRepository;

    public Board findBoard(Long boardId){

        Board board =boardRepository.getById(boardId);
        increaseCount(board);
        boardRepository.save(board);
        return board;
    }

    public void increaseCount(Board board){

        board.setCount(board.getCount() + 1);
    }

};