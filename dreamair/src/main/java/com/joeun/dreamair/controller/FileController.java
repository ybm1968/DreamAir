// package com.joeun.dreamair.controller;

// import java.nio.file.Files;

// import javax.servlet.http.HttpServletResponse;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.multipart.MultipartFile;

// import com.joeun.dreamair.service.FileService;

// import lombok.extern.slf4j.Slf4j;



// @Slf4j
// @Controller
// @RequestMapping("/file")
// public class FileController {

//     @Autowired
//     private FileService fileService;


//     /**
//      * 파일 다운로드
//      * @param fileNo
//      * @param response
//      * @throws Exception
//      */
//     @GetMapping(value="/{fileNo}")
//     public void fileDownload( @PathVariable("fileNo") int fileNo
//                              ,HttpServletResponse response  ) throws Exception {

//         int result = fileService.download(fileNo, response);
        
//         if( result == 0 ) {
//              response.setStatus(response.SC_BAD_REQUEST);
//         }
//     }


    
//     /**
//      *  파일 삭제
//      * @param file
//      * @return
//      * @throws Exception
//      */
//     @DeleteMapping("")
//     // public ResponseEntity<String> deleteFile(@RequestBody Files file) throws Exception {
//     public ResponseEntity<String> deleteFile(Files file) throws Exception {
//         log.info("[DELETE] - /file");
//         int fileNo = file.getFileNo();
//         log.info("fileNo : " + fileNo);
//         if( fileNo == 0 )
//             return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);       

//         int result = fileService.delete(fileNo);

//         if( result == 0 )
//             return new ResponseEntity<String>("FAIL", HttpStatus.OK);    
        
//         return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
//     }
    
    // // 파일 등록
    // @Override
    // public void saveItemImg(Files file, MultipartFile itemImgFile) throws Exception{
    //     String originName = itemImgFile.getOriginalFilename();
    //     String fileName = "";
    //     String filePath = "";

    //     //파일 업로드
    //     if(!StringUtils.isEmpty(oriImgName)){
    //         // 로컬에 저장된 파일의 이름을 변수에 저장
    //         imgName = fileService.uploadFile(file.filepath, file.originName,
    //                 itemImgFile.getBytes());
    //         // 저장할 파일 이미지를 불러올 경로 설정
    //         imgUrl = "/images/item/" + imgName;
    //     }

    //     @Override
    // public void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws Exception{
    //     if(!itemImgFile.isEmpty()){
    //         ItemImg savedItemImg = itemImgRepository.findById(itemImgId)
    //                 .orElseThrow(EntityNotFoundException::new);

    //         //기존 이미지 파일 삭제
    //         if(!StringUtils.isEmpty(savedItemImg.getImgName())) {
    //             fileService.deleteFile(itemImgLocation+"/"+
    //                     savedItemImg.getImgName());
    //         }

    //         String oriImgName = itemImgFile.getOriginalFilename();
    //         String imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
    //         String imgUrl = "/images/item/" + imgName;
    //         savedItemImg.updateItemImg(oriImgName, imgName, imgUrl);
    //     }
    // }
// }
