package com.example.yingshi_test.entity;

import lombok.Data;

/**
 * @author Hoodie
 * @since 2022/5/18
 */
@Data
public class AccessToken {
    @Data
    public static class D {
        private String accessToken;
        private Long expireTime;
    }
    private D data;
    private String code;
    private String msg;
}
