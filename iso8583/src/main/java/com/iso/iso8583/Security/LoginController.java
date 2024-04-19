package com.iso.iso8583.Security;

import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("security")
public class LoginController {

//    @GetMapping("/home")
    public String home(){
        return "Welcome to home";
    }

//    @GetMapping("/secured")
    public String secured(){
        return "Welcome to secured page";
    }
}
