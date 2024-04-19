package com.telusko.springMvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String home(){
        System.out.println("webpage requested");
        return "index";
    }
}
