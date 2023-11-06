package com.joeun.dreamair.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {

    // product 테이블
    private int productNo;
    private String productId;
    private int routeNo;
    private String name;
    private String productCat;
    private int productPrice;
    private String departure;
    private String destination;
    private String productRegDate;
    private String productUpdDate;
    private int unitInStock;
    private String description;
    private String File;
    
    
    // seat 테이블
    private String seatNo;
    private int bookingNo;
    private String passengerName;
    private int flightNo;
    private String seatClass;
    private String status;

    // flight 테이블
    // private int flightNo;
    private String flightName;

    // private String seatNo;
    private int seatMax;
    private int seatRemaining;
    private int seatUsed;

    // cart 테이블
    private int cartNo;
    private int userNo;
    private int userNo2;
    private int cartCnt;

    // route    
    // private int routeNo;    
    // private String departure;     
    // private String destination;
    private String departureTime;     
    private String destinationTime;

    private List<Files> files;
    private Files thumbnail;
    private String fileName;
    private String fileType;
    
    private List<MultipartFile> file;

}
