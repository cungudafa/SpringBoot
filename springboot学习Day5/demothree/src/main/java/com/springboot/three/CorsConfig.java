package com.springboot.three;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 全局配置
 */
@Configuration//一定得加上
public class CorsConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//配置可以被跨域的路径
                .allowedOrigins("*")//允许所有的请求域名访问我们的跨域资源
                .allowCredentials(true)//是否允许用户发送、处理 cookie
                .allowedMethods("GET", "POST", "DELETE", "PUT")//允许所有的请求方法访问该跨域资源服务器
                .maxAge(3600);//预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
    }
}