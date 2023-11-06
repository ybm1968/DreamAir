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

import com.joeun.dreamair.dto.Files;
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

        // //* - 상품 조회        
        // @GetMapping(value="/product_list")
        // public String productselect(@ModelAttribute int productNo) throws Exception{
        //     // Product product = productService.product_select(productNo);
        //     return "product/product_list";
        // }

        //* - 상품 등록       
        @GetMapping(value="/product_insert")
            public String productInsert() {
                return "product/product_insert";
        }

        //* - 상품 등록 처리  
        @PostMapping(value="/product_insert")
            public String productInsertPro(Product product) throws Exception {
        //         // 필수값 없으면 다시 상품 등록 페이지로
        // if(bindingResult.hasErrors()){
        //     return "item/itemForm";
        // }

        // if(itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null){
        //     model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값 입니다.");
        //     return "item/itemForm";
        // }

        // try {
        //     // 상품 저장 로직 호출
        //     itemService.saveItem(itemFormDto, itemImgFileList);
        // } catch (Exception e){
        //     model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
        //     return "item/itemForm";
        // }
                 int result = productService.product_insert(product);

                // 상품 입출고 처리(입고)
                int productNo = product.getProductNo();
                int amount = product.getUnitInStock();
                String type = "IN";

                ProductIo productIo = new ProductIo();
                productIo.setProductNo(productNo);
                productIo.setAmount(amount);
                productIo.setType(type);

                int result2 = productService.productIO_insert(product);
                if( result2 == 0 ){
                    log.info("상품 입출고 중 에러 발생");
                }

                if( result == 0 ) return "product/product_insert";
            return "redirect:/product/product_list";
        }

        //* - 상품 수정   
        @GetMapping(value="/product_update/{productNo}")
        public String productUpdate(@PathVariable("productNo") int productNo, Model model) throws Exception {
           
            model.addAttribute("product", productService.product_update(productNo));
                        
            return "product/product_update";
        }

        //* - 상품 수정 처리     
        @PostMapping(value="/product_update")
        public String productUpdatePro(@ModelAttribute Product product) throws Exception {
                int result = productService.product_insert(product);
                if( result == 0 ) return "redirect:/product/product_update";
            return "redirect:/product/product_list";
        }

        //* - 상품 삭제 처리       
        @GetMapping(value="/product_delete")
        public String productDelete(@RequestParam int productNo) throws Exception {
            productService.product_delete(productNo);
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

        // //* - 항공기 조회        
        // @GetMapping(value="/product_list")
        // public String productselect(@ModelAttribute int productNo) throws Exception{
        //     // Product product = productService.product_select(productNo);
        //     return "product/product_list";
        // }

        //* - 항공기 등록       
        @GetMapping(value="/flight_insert")
            public String flightInsert(@ModelAttribute Product product) {
            return "product/flight_insert";
        }

        //* - 항공기 등록 처리  
        @PostMapping(value="/flight_insert")
            public String flightInsertPro(@ModelAttribute Product product) throws Exception {
                int result = productService.flight_insert(product);
                if( result == 0 ) return "redirect:/product/flight_insert";
            return "redirect:/product/flight_list";
        }

        //* - 항공기 수정   
        @GetMapping(value="/flight_update/{flightNo}")
        public String flightUpdate(@PathVariable("flightNo") int flightNo, Model model) throws Exception {
           
            model.addAttribute("flight", productService.flight_update(flightNo));
                        
            return "product/flight_update";
        }

        //* - 항공기 수정 처리     
        @PostMapping(value="/flight_update")
        public String flightUpdatePro(@ModelAttribute Product product) throws Exception {
                int result = productService.flight_insert(product);
                if( result == 0 ) return "redirect:/product/flight_update";
            return "redirect:product/flight_list";
        }

        //* - 항공기 삭제 처리       
        @GetMapping(value="/flight_delete")
        public String flightDelete(@RequestParam int flightNo) throws Exception {
            productService.flight_delete(flightNo);
           return "redirect:/product/flight_list";
        }



}