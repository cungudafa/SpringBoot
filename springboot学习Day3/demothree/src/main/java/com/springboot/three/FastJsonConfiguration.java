package com.springboot.three;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;


@Configuration//@Configuration让SpringBoot自动加载类内的配置
//WebMvcConfigurationSupport是SpringBoot内部提供专门处理用户自行添加的配置，
// 里面不仅仅包含了修改视图的过滤还有其他很多的方法，包括后面可能会用到的拦截器，过滤器，Cors配置等.
public class FastJsonConfiguration extends WebMvcConfigurationSupport {
    /**
     * 修改自定义消息转换器
     * @param converters 消息转换器列表
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        //调用父类配置
        super.configureMessageConverters(converters);
        //创建消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,//消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
                SerializerFeature.WriteMapNullValue,//是否输出值为null的字段,默认为false。
                SerializerFeature.WriteNullStringAsEmpty//数据库字段设置了NULL时，前端返回json为""替代null
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastConverter);
    }
}