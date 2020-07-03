package com.demo.webadmin.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * HTTP接口返回对象
 * YangKuo 2018/8/20 15:35
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code; // 状态码
    private String message; // 返回信息
    private T data; // 返回具体对象信息

    private String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    private static  ResponseResult success = new  ResponseResult(ResultCodeMsg.CODE_SUCCESS);

    private static ResponseResult error = new ResponseResult(ResultCodeMsg.CODE_EXCEPTION, "失败");

    public ResponseResult() {

    }

    public ResponseResult(int code) {
        this.code = code;
    }

    public ResponseResult(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public ResponseResult(int code, String message, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static  ResponseResult success() {
        return success;
    }

    public static <T> ResponseResult<T> success(T data) {
        if (data == null) {
            List<T> a = new ArrayList<>();
            data = (T) a;
        }
        return new ResponseResult<>(ResultCodeMsg.CODE_SUCCESS, "成功", data);
    }

    public static ResponseResult error() {
        return error;
    }

    public static ResponseResult<Object> error(ResultEnum resultEnum) {
        ResponseResult<Object> result = new ResponseResult<>();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMsg());
        return result;
    }

    public static ResponseResult error(Integer code, String msg) {
        return new ResponseResult(code, msg);
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess(){
        return Objects.equals(this.code, ResultCodeMsg.CODE_SUCCESS);
    }

    public boolean isError(){
        return !Objects.equals(this.code, ResultCodeMsg.CODE_SUCCESS);
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
