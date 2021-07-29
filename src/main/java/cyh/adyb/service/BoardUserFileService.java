package cyh.adyb.service;

import cyh.adyb.domain.Board;
import cyh.adyb.domain.UserFile;
import cyh.adyb.repository.UserFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardUserFileService {
    private final UserFileRepository userFileRepository;

    public void userFilelRepository(List<UserFile> userFileList, Board board){

        if(userFileList.isEmpty()){
            return;
        }
        for(UserFile userfile : userFileList){
            userfile.setBoard(board);
            userFileRepository.save(userfile);
        }
    }

};