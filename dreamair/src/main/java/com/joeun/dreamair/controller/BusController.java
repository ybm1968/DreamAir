package com.joeun.dreamair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bus")
public class BusController {

     /**
     * 공항버스 예매 화면
     * @param param
     * @return
     */
    @GetMapping(value={"/", ""})
    public String index() {
        return "bus/index";
    }


    @GetMapping(value="/{sub}")
    public String index(@PathVariable String sub) {
        return "bus/" + sub;
    }

    
    
}
