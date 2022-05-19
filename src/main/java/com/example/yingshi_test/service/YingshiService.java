package com.example.yingshi_test.service;

import com.example.yingshi_test.entity.AccessToken;
import com.example.yingshi_test.param.AccessTokenParam;
import org.springframework.stereotype.Service;

/**
 * @author Hoodie
 * @since 2022/5/19
 */
public interface YingshiService {
    AccessToken getToken(AccessTokenParam param);
}
