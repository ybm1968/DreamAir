package com.joeun.dreamair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import groovyjarjarpicocli.CommandLine.Model;



@Controller
@RequestMapping("/booking")
public class BookingController {
    

    @GetMapping(value="/select")
    public String select(Model model) {

        

        return "user/select";
    }

    @GetMapping(value="/info")
    public String info() {
        return "user/info";
    }

    @GetMapping(value="/seat")
    public String seat() {
        return "user/seat";
    }
    
    @GetMapping(value="/notice")
    public String notice() {
        return "user/notice";
    }

    @GetMapping(value="/payment")
    public String payment() {
        return "user/payment";
    }
    
    
    

}
