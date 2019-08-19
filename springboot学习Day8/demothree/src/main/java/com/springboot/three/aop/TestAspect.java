package com.springboot.three.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class TestAspect {

    //com.springboot.three.controller 包中所有的类的所有方法切面
    //@Pointcut("execution(public * com.springboot.three.controller.*.*(..))")

    //只针对 MessageController 类切面
    //@Pointcut("execution(public * com.springboot.three.controller.MessageController.*(..))")

    //统一切点,对com.springboot.three.controller及其子包中所有的类的所有方法切面
    @Pointcut("execution(public * com.springboot.three.controller..*.*(..))")
    public void Pointcut() {
    }
    //@Around：环绕通知
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("我是环绕通知!!!");
        log.info("方法 ："+pjp.getSignature().getName());
        //AOP代理类的名字
        log.info("方法所在包 :"+pjp.getSignature().getDeclaringTypeName());

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String[] strings = methodSignature.getParameterNames();
        log.info("参数名 ："+ Arrays.toString(strings));
        log.info("参数值ARGS : " + Arrays.toString(pjp.getArgs()));

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        // 记录下请求内容
        log.info("请求URL : " + req.getRequestURL().toString());
        log.info("HTTP_METHOD : " + req.getMethod());
        log.info("IP : " + req.getRemoteAddr());
        log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        
        //开始调用时间
        // 计时并调用目标函数
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        Long time = System.currentTimeMillis() - start;
        //记录返回参数
        log.info("请求返回结果result: "+result);
        //设置消耗总时间
        log.info("环绕通知完毕!!!");
        log.info("请求总耗时time:"+time);
        return result;
    }

}