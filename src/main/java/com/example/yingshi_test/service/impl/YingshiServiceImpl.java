package com.example.yingshi_test.service.impl;

import com.example.yingshi_test.entity.AccessToken;
import com.example.yingshi_test.param.AccessTokenParam;
import com.example.yingshi_test.service.YingshiService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author Hoodie
 * @since 2022/5/19
 */
@Service
public class YingshiServiceImpl implements YingshiService {

    private final RestTemplate restTemplate;

    public YingshiServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    /*
    * 根据appKey和secret获取accessToken
    * */
    @Override
    public AccessToken getToken(AccessTokenParam param) {
        System.out.println("接收到参数为："+ param);
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        /*System.out.println(accessTokenParam.getAppKey());
        System.out.println(accessTokenParam.getAppSecret());*/
        request.add("appKey", param.getAppKey());
        request.add("appSecret", param.getAppSecret());
        System.out.println(request);
        String url = "https://open.ys7.com/api/lapp/token/get";
        AccessToken accessToken = restTemplate.postForObject(url, request, AccessToken.class);
        return accessToken;
    }



}
