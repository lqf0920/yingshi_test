package com.example.yingshi_test.controller;

import com.example.yingshi_test.entity.AccessToken;
import com.example.yingshi_test.param.AccessTokenParam;
import com.example.yingshi_test.service.YingshiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /*
    * x-www-form-urlencoded格式数据等同于：
    * https://open.ys7.com/api/lapp/token/get?appKey=04c84edbcca84fb584681802e4df78f3&appSecret=036cd44d88b5961e5c21f76a573230ca
    * */
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

    //测试不同的请求方法和路径
    @GetMapping("/test3")  //http://localhost:8080/yingshi/test3?name=qq&age=11
    public String test3(@RequestParam String name, @RequestParam String age){
        return name + age;
    }

    @GetMapping("/test4/{name}/{age}")  // http://localhost:8080/yingshi/test4/qq/11
    public String test4(@PathVariable String name, @PathVariable String age){
        return name + age;
    }
}
