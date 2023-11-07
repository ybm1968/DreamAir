package com.joeun.dreamair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.service.BookingService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@Slf4j
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    

}
