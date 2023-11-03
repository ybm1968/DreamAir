package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 항공기
     */
    // 항공기 전체 조회
    @Override
    public List<Product> flight_list() throws Exception {
       List<Product> flightList = productMapper.flight_list();
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
    public int productIO_insert(Product product) throws Exception {
       int result = productMapper.productIO_insert(product);
       return result;
    }
    
}
