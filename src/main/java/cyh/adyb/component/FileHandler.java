package cyh.adyb.component;


import cyh.adyb.domain.User;
import cyh.adyb.domain.UserFile;
import cyh.adyb.repository.UserRepository;
import cyh.adyb.service.BoardUserFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileHandler {

    private final BoardUserFileService boardUserFileService;
    private final UserRepository userRepository;

    public List<UserFile> UserFileUpload(List<MultipartFile> files, String userId) throws IOException {

        // 반환할 파일 리스트
        List<UserFile> fileList = new ArrayList<>();
        User user = userRepository.findByUserId(userId);

        // 전달되어 온 파일이 존재할 경우
        if(!CollectionUtils.isEmpty(files)) {
            // 파일명을 업로드 한 날짜로 변환하여 저장
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd");
            String current_date = now.format(dateTimeFormatter);

            // 프로젝트 디렉터리 내의 저장을 위한 절대 경로 설정
            // 경로 구분자 File.separator 사용



        for(MultipartFile multipartFile : files) {
            String path = "C:/test"+"/"+userId+"/"; //파일 저장 경로, 설정파일로 따로 관리한다.

            // 파일의 확장자 추출
            String extension;
            String contentType = multipartFile.getContentType();

            // 확장자명이 존재하지 않을 경우 처리 x
            if(ObjectUtils.isEmpty(contentType)) {
                break;
            }

            extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

            // 파일명 중복 피하고자 나노초까지 얻어와 지정
            String new_file_name = current_date + "_"+System.nanoTime() + "." + extension;

            File file = new File(path + new_file_name); //파일 저장 경로 확인, 없으면 만든다.
            if (!file.exists()) {
                file.mkdirs();
            }
            UserFile userFile = new UserFile();
            // 파일 DTO 생성


            userFile.setUser(user);
            userFile.setFilePath(path + new_file_name);
            userFile.setFileSize(multipartFile.getSize());
            userFile.setOrigFileName(multipartFile.getOriginalFilename());
            userFile.setSavedName(new_file_name);


            log.info("user = {}", user.getUserId());
            log.info("path = {}", path);
            log.info("size = {}", multipartFile.getSize());
            log.info("origfilename = {}", multipartFile.getOriginalFilename());


            // 생성 후 리스트에 추가
            fileList.add(userFile);

            // 업로드 한 파일 데이터를 지정한 파일에 저장
            multipartFile.transferTo(file);

            // 파일 권한 설정(쓰기, 읽기)
            file.setWritable(true);
            file.setReadable(true);
        }
            return fileList;
    }

        return null;

    }



};