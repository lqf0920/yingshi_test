package com.example.yingshi_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hoodie
 * @since 2022/5/19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get")
    public String get1(){
        return "hello world!";
    }

    @GetMapping("/get2")
    public String get2(@RequestParam String param){
        return "参数为"+ param;
    }

}
