package com.joeun.dreamair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

        @Autowired
        private ProductService productService;

        //* - 상품 목록  - [GET] - /admin/product_list
        @GetMapping(value="/product_list")
        public String productlist(Model model) throws Exception {
            log.info("[GET] - /admin/product_list");

            List<Product> productList= productService.product_list();
            model.addAttribute("productList", productList);
            return "admin/product_list";
        }

        //* - 상품 조회            - [GET] - /admin/product_select
        @GetMapping(value="/product_list")
        public String productselect(@ModelAttribute int productNo) throws Exception{
            Product product = productService.product_select(productNo);
            return "admin/product_list";
        }

        //* - 상품 등록            - [GET] - /admin/product_insert
        @GetMapping(value="/product_insert")
            public String productinsert(@ModelAttribute Product product) {
            return "admin/product_insert";
        }

        //* - 상품 등록 처리       - [POST] - /admin/product_insert
        @PostMapping(value="/product_insert")
            public String productinsertPro(@ModelAttribute Product product) throws Exception {
                int result = productService.product_insert(product);
                if( result == 0 ) return "admin/product_insert";
            return "redirect:/product_list";
        }

        //* - 상품 수정            - [GET] - /admin/product_update
        @GetMapping(value="/product_update")
        public String productupdate(@ModelAttribute Product product) throws Exception {
            return "admin/product_update";
        }

        //* - 상품 수정 처리       - [POST] - /admin/product_update
        @PostMapping(value="/product_update")
        public String productupdatePro(@ModelAttribute Product product) throws Exception {
                int result = productService.product_insert(product);
                if( result == 0 ) return "admin/product_update";
            return "redirect:/product_list";
        }

        //* - 상품 삭제 처리       - [POST] - /admin/product_delete
        @GetMapping(value="/product_update")
        public String productdelete(@ModelAttribute int productNo) throws Exception {
           return "admin/product_update";
        }

}
