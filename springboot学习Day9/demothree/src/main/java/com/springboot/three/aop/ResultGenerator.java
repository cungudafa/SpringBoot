package com.springboot.three.aop;

/**
 * 响应结果,预处理
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    /**
     * 成功响应
     * code:200
     * 无参返回data：null
     * 成功信息：message：SUCCESS
     * @return
     */

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 成功响应
     * code:200
     * 有参返回data：实体类或集合
     * 成功信息：message：SUCCESS
     * @param data
     * @return
     */

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setSuccess(true)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    /**
     * 错误响应
     * code：400等
     * 无参返回data：null
     * 错误信息message："/by zero"等
     * @param message
     * @return
     */

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setSuccess(false)
                .setMessage(message);
    }
}