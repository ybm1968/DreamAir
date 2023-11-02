package com.joeun.dreamair.service;

import java.util.List;

import com.joeun.dreamair.dto.Product;

public interface ProductService {
    /**
     * 항공기 관리
     */
    // 항공기 전체 조회
    public List<Product> flight_list() throws Exception;

    // 항공기 정보 조회
    public Product flight_select(int flightNo) throws Exception;

    // 항공기 정보 등록
    public int flight_insert(Product flight) throws Exception;

    // 항공기 정보 수정
    public int flight_update(int flightNo) throws Exception;

    // 항공기 정보 삭제
    public int flight_delete(int flightNo) throws Exception;


    /**
     * 상품 관리
     */
    // 상품(항공권) 전체 조회
    public List<Product> product_list() throws Exception;

    // 상품(항공권) 선택 조회
    public Product product_select(int productNo) throws Exception;

    // 상품(항공권) 등록
    public int product_insert(Product product) throws Exception;

    // 상품(항공권) 수정
    public int product_update(int productNo) throws Exception;

    // 상품(항공권) 삭제
    public int product_delete(int productNo) throws Exception;


    /**
     * 상품 입출고
     */
    
}
