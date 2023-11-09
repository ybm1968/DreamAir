package com.joeun.dreamair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.dto.ProductIo;
import com.joeun.dreamair.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // @Autowired
    // private FileService fileService;
    
    // [product] index 화면 
    @GetMapping(value={"/"})
    public String index() {
        return "product/index";
    }

    // 상품 목록 조회 
    @GetMapping(value="/product_list")
    public String product_list(Model model) throws Exception {
        log.info("[GET] - /product/product_list");

        List<Product> productList = productService.product_list();
        model.addAttribute("ProductList", productList);
        
        return "product/product_list";
    }
    
    //* - 상품 등록       
    @GetMapping(value="/product_insert")
    public String productInsert(@ModelAttribute Product product) {
        return "product/product_insert";
    }
    
    //* - 상품 등록 처리  
    @PostMapping(value="/product_insert")
    public String productInsertPro(@ModelAttribute Product product) throws Exception {
        
        int result = productService.product_insert(product);
        
        // 상품 입출고 처리(입고)
        int productNo = product.getProductNo();
        int amount = product.getUnitInStock();
        String type = "IN";

        ProductIo productIo = new ProductIo();
        productIo.setProductNo(productNo);
        productIo.setAmount(amount);
        productIo.setType(type);

        int result2 = productService.productIO_insert(productIo);
        if( result2 == 0 ){
            log.info("상품 입출고 중 에러 발생");
        }

        if( result == 0 ) return "product/product_insert";
        return "redirect:/product/product_list";
    }

    //* - 상품 수정   
    @GetMapping(value="/product_update")
    public String productUpdate(Model model, int productNo, Product product) throws Exception {
        log.info("[GET] - /product/product_update");

        model.addAttribute("product", product);                    
        return "product/product_update";
    }

    //* - 상품 수정 처리     
    @PostMapping(value="/product_update")
    public String productUpdatePro(Product product) throws Exception {
        log.info("[POST] - /product/product_update");
        int result = productService.product_insert(product);
        int productNo = product.getProductNo();

        if( result == 0 ) return "redirect:/product/product_update?productNo" + productNo;
        return "redirect:/product/product_list";
    }

    //* - 상품 삭제 처리       
    @PostMapping(value="/product_delete")
    public String productDelete(int productNo) throws Exception {
        log.info("[POST] - /product/product_delete");

        int result = productService.product_delete(productNo);

        if(result == 0) return "redirect:/product/product_update?productNo=" + productNo;
        return "redirect:/product/product_list";
    }

    // 항공기
    //* - 항공기 목록 
    @GetMapping(value="/flight_list")
    public String flight_list(Model model) throws Exception {
        log.info("[GET] - /product/flight_list");

        List<Product> flightList = productService.flight_list();
        model.addAttribute("FlightList", flightList);
        
        return "product/flight_list";
    }

    //* - 항공기 등록       
    @GetMapping(value="/flight_insert")
        public String flightInsert() {
        return "product/flight_insert";
    }

    //* - 항공기 등록 처리  
    @PostMapping(value="/flight_insert")
        public String flightInsertPro(Product flight) throws Exception {
        log.info("[POST] - /product/flight_lnsert");

        int result = productService.flight_insert(flight);
        if( result == 0 ) return "redirect:/product/flight_insert";
        return "redirect:/product/flight_list";
    }

     //* - 항공기 수정   
    @GetMapping(value="/flight_update")
    public String flightUpdate(Model model, int flightNo) throws Exception {
        log.info("[GET] - /product/flight_update");

        //Product flight = productService.product_update(flightNo);
        Product flight = new Product();
        model.addAttribute("flight", flight);                    
        return "product/flight_update";
    }

    //* - 항공기 수정 처리     
    @PostMapping(value="/flight_update")
    public String flightUpdatePro(Product flight) throws Exception {
        log.info("[POST] - /product/flight_update");

        int result = productService.flight_insert(flight);
        int flightNo = flight.getFlightNo();

        if( result == 0 ) return "redirect:/product/flight_update?flightNo" + flightNo;
        return "redirect:/product/flight_list";
    }

    //* - 항공기 삭제 처리       
    @GetMapping(value="/flight_delete")
    public String flightDelete(int flightNo) throws Exception {
        log.info("[POST] - /product/flight_delete");

        int result = productService.flight_delete(flightNo);
        if(result == 0) return "redirect:/product/flight_update?productNo=" + flightNo;
        return "redirect:/product/flight_list";
    }

}