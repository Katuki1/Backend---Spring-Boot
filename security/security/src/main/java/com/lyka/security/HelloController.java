package com.lyka.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello from our API");
    }

    @GetMapping("/say-bye")
    public  ResponseEntity<String> goodbyeWorld(){
        return  ResponseEntity.ok("Goodbye and Come again");
    }
}
