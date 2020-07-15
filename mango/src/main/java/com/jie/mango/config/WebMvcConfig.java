package com.jie.mango.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") //允许跨域访问的路径
                .allowedOrigins("*") //允许跨域访问的路径
                .allowedMethods("POST","PUT","OPTIONS","DELETE") //允许请求方法
                .maxAge(168000) //预检间隔时间
                .allowedHeaders("*")  //允许头部设置
                .allowCredentials(true); //是否发送cookie
    }
}
