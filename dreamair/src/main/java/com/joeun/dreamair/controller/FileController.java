package com.joeun.dreamair.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.joeun.dreamair.dto.Files;
import com.joeun.dreamair.service.FileService;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 파일 다운로드
     * @param fileNo
     * @param response
     * @throws Exception
     */
    @GetMapping(value="/{fileNo}")
    public void fileDownload( @PathVariable("fileNo") int fileNo
                             ,HttpServletResponse response  ) throws Exception {

        int result = fileService.download(fileNo, response);
        
        if( result == 0 ) {
             response.setStatus(response.SC_BAD_REQUEST);
        }
    }


    /**
     * 썸네일 이미지
     * @param fileNo
     * @param response
     * @throws Exception
     */
    @GetMapping(value="/img/{fileNo}")
    public void thumbnail( @PathVariable("fileNo") int fileNo
                             ,HttpServletResponse response  ) throws Exception {

        int result = fileService.thumbnail(fileNo, response);
        
        if( result == 0 ) {
             response.setStatus(response.SC_BAD_REQUEST);
        }
    }


    
    /**
     *  파일 삭제
     * @param file
     * @return
     * @throws Exception
     */
    @DeleteMapping("")
    // public ResponseEntity<String> deleteFile(@RequestBody Files file) throws Exception {
    public ResponseEntity<String> deleteFile(Files file) throws Exception {
        log.info("[DELETE] - /file");
        int fileNo = file.getFileNo();
        log.info("fileNo : " + fileNo);
        if( fileNo == 0 )
            return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);       

        int result = fileService.delete(fileNo);

        if( result == 0 )
            return new ResponseEntity<String>("FAIL", HttpStatus.OK);    
        
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }
    

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        if (multipartFile.isEmpty()) {
            return "redirect:/errorPage"; // 에러 페이지로 리다이렉트
        }

        String fileName = multipartFile.getOriginalFilename(); // 파일 이름
        String filePath = "/your/directory/path/" + fileName; // 실제 파일 저장 경로, 실제 서비스에서는 수정 필요

        // 파일 저장 로직 (FileOutputStream 사용)

        Files file = new Files();
        file.setFileName(fileName);
        file.setOriginName(fileName);
        file.setFilePath(filePath);
        file.setFileSize(multipartFile.getSize());
        // ... (다른 필요한 정보 저장)

        fileService.insert(file); // 파일 정보 DB 저장

        return "redirect:/listPage"; // 리스트 페이지로 리다이렉트
    }



}
