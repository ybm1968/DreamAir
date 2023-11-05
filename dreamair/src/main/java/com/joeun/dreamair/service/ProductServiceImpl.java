package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.mapper.FileMapper;
import com.joeun.dreamair.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FileMapper FileMapper;

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

//     // 상품 등록
//     @Override
//     public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception{

//         //상품 등록
//         Item item = itemFormDto.createItem(); // 입력받은 폼으로부터 객체 생성
//         itemRepository.save(item); // 상품데이터저장

//         //이미지 등록
//         for(int i=0;i<itemImgFileList.size();i++){
//             ItemImg itemImg = new ItemImg();
//             itemImg.setItem(item);

//             if(i == 0)
//                 itemImg.setRepimgYn("Y");
//             else
//                 itemImg.setRepimgYn("N");

//             itemImgService.saveItemImg(itemImg, itemImgFileList.get(i)); //상품의 이미지 정보 저장
//         }

//         return item.getId();
//     }
// }
    
}
