package com.joeun.dreamair.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.joeun.dreamair.dto.Files;
import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.dto.ProductIo;
import com.joeun.dreamair.mapper.FileMapper;
import com.joeun.dreamair.mapper.ProductMapper;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FileMapper fileMapper;

    @Value("${upload.path}")            // application.properties 에 설정한 업로드 경로 속성명
    private String uploadPath;          // 업로드 경로

    /**
     * 항공기
     */
    // 항공기 전체 조회
    @Override
    public List<Product> flight_list() throws Exception {
       List<Product> flightList = productMapper.flight_list();

       for (int i = 0; i < flightList.size(); i++) {
            Files file = new Files();
            file.setParentTable("flight");

            log.info("fligthList.get(i) : " + flightList.get(i));

            // file.setParentNo(flightList.get(i).getFlightNo());
            file.setParentNo(9);

            file = fileMapper.selectThumbnail(file);
            if(file != null) {
        		flightList.get(i).setFileName(file.getFileName());
        		flightList.get(i).setFileType(file.getFileType());
            }
            flightList.get(i).setThumbnail(file);
        }
       return flightList;
    }

    // 항공기 정보 조회
    @Override
    public Product flight_select(int flightNo) throws Exception {
       Product flight = productMapper.flight_select(flightNo);
       return flight;
    }

    // 항공기 정보 등록
    @Override
    public int flight_insert(Product flight) throws Exception {
        
        int result = productMapper.flight_insert(flight);

        String parentTable = "flight";
        int parentNo = productMapper.flight_maxPk();

        //파일 업로드 
        List<MultipartFile> fileList = flight.getFile();

        if( !fileList.isEmpty() )
        for (MultipartFile file : fileList) {

            if( file.isEmpty() ) continue;

            // 파일 정보 : 원본파일명, 파일 용량, 파일 데이터 
            String originName = file.getOriginalFilename();
            long fileSize = file.getSize();
            byte[] fileData = file.getBytes();
            
            // 업로드 경로
            // 파일명 중복 방지 방법(정책)
            // - 날짜_파일명.확장자
            // - UID_파일명.확장자

            // UID_강아지.png
            String fileName = UUID.randomUUID().toString() + "_" + originName;

            // c:/upload/UID_강아지.png
            String filePath = uploadPath + "/" + fileName;

            // 파일업로드
            // - 서버 측, 파일 시스템에 파일 복사
            // - DB 에 파일 정보 등록
            File uploadFile = new File(uploadPath, fileName);
            FileCopyUtils.copy(fileData, uploadFile);       // 파일 업로드

            // FileOutputStream fos = new FileOutputStream(uploadFile);
            // fos.write(fileData);
            // fos.close();

            Files uploadedFile = new Files();
            uploadedFile.setParentTable(parentTable);
            uploadedFile.setParentNo(parentNo);
            uploadedFile.setBoardNo(parentNo);
            uploadedFile.setFileName(fileName);
            uploadedFile.setFilePath(filePath);
            uploadedFile.setOriginName(originName);
            uploadedFile.setFileSize(fileSize);
            uploadedFile.setFileCode(0);

            fileMapper.insert(uploadedFile);
        }
        return result;
    }

    // 항공기 정보 수정
    @Override
    public int flight_update(int flightNo) throws Exception {
        int result = productMapper.flight_update(flightNo);
        return result;
    }

    // 항공기 정보 삭제
    @Override
    public int flight_delete(int flightNo) throws Exception {
        int result = productMapper.flight_delete(flightNo);
        return result;
    }

    /**
     * 상품
     */
    // 상품(항공권) 전체 조회
    @Override
    public List<Product> product_list() throws Exception {
        List<Product> productList = productMapper.product_list();

         for (int i = 0; i < productList.size(); i++) {
            Files file = new Files();
            file.setParentTable("product");
            file.setParentNo(productList.get(i).getFlightNo());

            file = fileMapper.selectThumbnail(file);
            if(file != null) {
        		productList.get(i).setFileName(file.getFileName());
        		productList.get(i).setFileType(file.getFileType());
            }
            productList.get(i).setThumbnail(file);
        }
        return productList;
    }

    // 상품(항공권) 선택 조회
    @Override
    public Product product_select(int productNo) throws Exception {
        Product product = productMapper.product_select(productNo);
        return product;
    }

    // 상품(항공권) 등록
    @Override
    public int product_insert(Product product) throws Exception {
        
        int result = productMapper.product_insert(product);

        String parentTable = "product";
        int parentNo = productMapper.flight_maxPk();

        //파일 업로드 
        List<MultipartFile> fileList = product.getFile();

        if( !fileList.isEmpty() )
        for (MultipartFile file : fileList) {

            if( file.isEmpty() ) continue;

            // 파일 정보 : 원본파일명, 파일 용량, 파일 데이터 
            String originName = file.getOriginalFilename();
            long fileSize = file.getSize();
            byte[] fileData = file.getBytes();
            
            // 업로드 경로
            // 파일명 중복 방지 방법(정책)
            // - 날짜_파일명.확장자
            // - UID_파일명.확장자

            // UID_강아지.png
            String fileName = UUID.randomUUID().toString() + "_" + originName;

            // c:/upload/UID_강아지.png
            String filePath = uploadPath + "/" + fileName;

            // 파일업로드
            // - 서버 측, 파일 시스템에 파일 복사
            // - DB 에 파일 정보 등록
            File uploadFile = new File(uploadPath, fileName);
            FileCopyUtils.copy(fileData, uploadFile);       // 파일 업로드

            FileOutputStream fos = new FileOutputStream(uploadFile);
            fos.write(fileData);
            fos.close();

            Files uploadedFile = new Files();
            uploadedFile.setParentTable(parentTable);
            uploadedFile.setParentNo(parentNo);
            uploadedFile.setBoardNo(parentNo);
            uploadedFile.setFileName(fileName);
            uploadedFile.setFilePath(filePath);
            uploadedFile.setOriginName(originName);
            uploadedFile.setFileSize(fileSize);
            uploadedFile.setFileCode(0);

            fileMapper.insert(uploadedFile);
        }


        return result;
    }

    // 상품(항공권) 수정
    @Override
    public int product_update(int productNo) throws Exception {
        int result = productMapper.product_update(productNo);
        return result;
    }

    // 상품(항공권) 삭제
    @Override
    public int product_delete(int productNo) throws Exception {
        int result = productMapper.product_delete(productNo);
        return result;
    }

    // 상품 입출고 등록
    @Override
    public int productIO_insert(ProductIo productIo) throws Exception {
       int result = productMapper.productIO_insert(productIo);
       return result;
    }
    
    
}
