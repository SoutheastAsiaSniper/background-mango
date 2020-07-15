package com.jie.mango.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class GetPasswordUtil {
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "123456";//密码原值
        Object salt = "YzcmCZNvbXocrsz9dm8e";//盐值
        int hashIterations = 2;//加密1024次
        String result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations).toString();
        System.out.println(result);
    }
}
