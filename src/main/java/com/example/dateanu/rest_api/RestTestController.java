// REST API using SPRING BOOT

package com.example.dateanu.rest_api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/request_test")
@Controller
//@RestController
public class RestTestController {

    @GetMapping(path = "/path-variable/{name}")
    public String testForPathVar(@PathVariable String name, Model model){
        model.addAttribute("testName",name);
        return "rest_test/test";
    }
    @GetMapping(path = "/hello")
    public String testForHello(Model model){
        model.addAttribute("testName","hello world");
        return "rest_test/test";
    }
}
