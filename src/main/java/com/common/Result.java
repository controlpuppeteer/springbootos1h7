package com.common;

import lombok.*;

import java.io.Serializable;

/**
 * API 返回封装
 *
 * @author DELL
 * @version 1.0
 * @date 2020-11-17 16:47
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 结果代码
     */
    @Getter
    @Setter
    private int status;

    /**
     * 业务错误代码
     */
    @Getter
    @Setter
    private String code;

    /**
     * 返回信息
     */
    @Getter
    @Setter
    private String msg;

    /**
     * 返回数据
     */
    @Getter
    @Setter
    private T data;

    /**
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok() {
        return restResult(null, Constants.SUCCESS, null, null);
    }

    /**
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data) {
        return restResult(data, Constants.SUCCESS, Constants.CODE_200, "请求成功");
    }

    /**
     *
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> ok(T data, String msg) {
        return restResult(data, Constants.SUCCESS, null, msg);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed() {
        return restResult(null, Constants.FAIL, null, null);
    }

    /**
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(String msg) {
        return restResult(null, Constants.FAIL, null, msg);
    }

    /**
     *
     * @param errorCode
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> failedWithErrorCode(String errorCode, String msg) {
        return restResult(null, Constants.FAIL, errorCode, msg);
    }

    /**
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(T data) {
        return restResult(data, Constants.FAIL, null, null);
    }

    /**
     *
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(T data, String msg) {
        return restResult(data, Constants.FAIL, null, msg);
    }

    /**
     * 请求结果
     * @param data
     * @param code
     * @param status
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> restResult(T data, int status, String code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setStatus(status);
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
