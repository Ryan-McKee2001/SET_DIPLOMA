package com.example.staffProject.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/yourname")
    public String HelloWorld(){
        return "Ryan McKee";
    }
}
