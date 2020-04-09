package com.codes.blues.core.model;

import com.codes.blues.core.constants.Constants;
import com.codes.blues.core.exception.BusinessException;

import java.util.UUID;

/**
 * 响应对象
 * @author linzg
 * @date 2020/03/02 15:25
 */
public class R<T> {

    // 响应代码
    private String code;

    // 响应消息
    private String message;

    // 响应数据
    private T data;

    // 异常ID
    private String errorId;

    // 异常数据
    private Object errorData;

    private R(String code, String message, T data, String errorId, Object errorData) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.errorId = errorId;
        this.errorData = errorData;
    }

    /**
     * 成功
     * @param message: 成功消息
     * @param data: 响应数据
     */
    public static <T> R success(String message, T data) {
        return new R(Constants.Response.SUCCESS.getCode(), message, data, null, null);
    }

    /**
     * 成功
     */
    public static <T> R success() {
        return R.success(Constants.Response.SUCCESS.getMessage(), null);
    }

    /**
     * 成功
     * @param data: 响应数据
     */
    public static <T> R data(T data) {
        return R.success(Constants.Response.SUCCESS.getMessage(), data);
    }

    /**
     * 失败
     * @param e: 业务异常
     */
    public static R failure(BusinessException e) {
        return new R(e.getCode(), e.getMessage(), null, e.getErrorId(), e.getErrorData());
    }

    /**
     * 失败
     * @param status: 响应状态
     */
    public static R failure(IResponseStatus status) {
        return new R(status.getCode(), status.getMessage(), null, UUID.randomUUID().toString(), null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(Object errorData) {
        this.errorData = errorData;
    }
}