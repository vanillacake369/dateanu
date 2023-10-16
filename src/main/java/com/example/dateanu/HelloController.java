package com.example.dateanu;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "live reload completed ?? ";
    }

    @GetMapping("/hello/inter")
    public String helloInter(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("greeting.message", null,locale);
    }
}
