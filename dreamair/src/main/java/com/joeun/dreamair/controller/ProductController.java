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
import com.joeun.dreamair.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

        @Autowired
        private ProductService productService;

        //* - 상품 목록 
        @GetMapping(value="/product_list")
        public String product_list(Model model) throws Exception {
            log.info("[GET] - /product/product_list");

            List<Product> productList= productService.product_list();
            model.addAttribute("ProductList", productList);
            return "/product_list";
        }

        // //* - 상품 조회        
        // @GetMapping(value="/product_list")
        // public String productselect(@ModelAttribute int productNo) throws Exception{
        //     // Product product = productService.product_select(productNo);
        //     return "product/product_list";
        // }

        //* - 상품 등록       
        @GetMapping(value="/product_insert")
            public String productInsert(@ModelAttribute Product product) {
            return "/product_list";
        }

        //* - 상품 등록 처리  
        @PostMapping(value="/product_insert")
            public String productInsertPro(@ModelAttribute Product product) throws Exception {
                int result = productService.product_insert(product);
                if( result == 0 ) return "product/product_insert";
            return "redirect:/product_list";
        }

        //* - 상품 수정   
        @GetMapping(value="/product_update/{productNo}")
        public String productUpdate(@PathVariable("productNo") int productNo, Model model) throws Exception {
           
            model.addAttribute("product", productService.product_update(productNo));
                        
            return "/product_update";
        }

        //* - 상품 수정 처리     
        @PostMapping(value="/product_update")
        public String productUpdatePro(@ModelAttribute Product product) throws Exception {
                int result = productService.product_insert(product);
                if( result == 0 ) return "admin/product_update";
            return "redirect:/product_list";
        }

        //* - 상품 삭제 처리       
        @GetMapping(value="/product_delete")
        public String productDelete(@RequestParam int productNo) throws Exception {
            productService.product_delete(productNo);
           return "redirect:/product_list";
        }



}
