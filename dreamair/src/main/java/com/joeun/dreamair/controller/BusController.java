package com.joeun.dreamair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/bus")
public class BusController {

   @GetMapping(value={"/", ""})
    public String index() {
        log.info("[GET] - /bus/");
        return "bus/index";
    }

    @GetMapping(value={"/bus/reservation"})
    public String busReservation() {
        log.info("[GET] - /bus/reservation");
        return "bus/reservation";
    }
    
}
