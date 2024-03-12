package comsecurity.Security2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BasicController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Kinyanjui!!!";
    }
     @GetMapping("/public")
    public String publicAccess(){
        return "Hello Public Kinyanjui!!!";
    }
     @GetMapping("/admin")
    public String admin(){
        return "Hello Admin Kinyanjui!!!";
    }
     @GetMapping("/user")
    public String user(){
        return "Hello User Kinyanjui!!!";
    }

}
