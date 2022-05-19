package com.example.yingshi_test.controller;

import com.example.yingshi_test.entity.AccessToken;
import com.example.yingshi_test.param.AccessTokenParam;
import com.example.yingshi_test.service.YingshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hoodie
 * @since 2022/5/18
 */
@RestController
@RequestMapping("/yingshi")
public class YingshiController {

    @Autowired
    private YingshiService yingshiService;

    @PostMapping("/accessToken")
    public AccessToken getAccessToken(@RequestBody AccessTokenParam accessTokenParam){
        return yingshiService.getToken(accessTokenParam);
    }

    //测试接收x-www-form-urlencoded格式数据
    @GetMapping("/test")
    public String test(@RequestBody String param) {
        System.out.println("接收到参数为："+ param);
        return param;
    }

    @PostMapping("/test1")   //只能使用post
    public String test1(@RequestParam Map<String, String> param) {
        System.out.println("接收到参数为："+ param);
        return null;
    }

    @PostMapping("/test2")   //只能使用post
    public String test2(@RequestParam LinkedHashMap<String, String> param) {
        System.out.println("接收到参数为："+ param);
        return null;
    }
}
