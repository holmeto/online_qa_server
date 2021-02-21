package com.junjia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetQaInfoController {

    @GetMapping("/test")
    public String GetQaInfo(){
        return "hello world";
    }


}
