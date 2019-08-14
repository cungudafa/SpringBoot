package com.springboot.three.aop;

        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestControllerAdvice;

        import javax.servlet.http.HttpServletRequest;

/**
 * 异常处理类
 * restful 风格处理异常信息
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
    /**
     * 全局异常捕捉处理
     * @param req
     * @param e
     * @return
     */

    @ExceptionHandler(Exception.class)
    public Result jsonErrorHandler(HttpServletRequest req, Exception e){
        return ResultGenerator.genFailResult(e.getMessage());
    }
}
