package com.demo.webadmin.common;

/**
 * 结果枚举类
 *
 * @author lvxc
 * 2018年7月4日 下午7:25:23
 */
public enum ResultEnum {

    UN_LOGIN(405, "用户未登陆"),
    EXECUTE_FAIL(999, "执行失败"),
    EMPTY_CONTENT(204, "查询为空"),
    SERVER_NOT_COMPLETE(503, "任务未完全执行"),
    LOGIN_FALSE(401, "登录失败,用户不存在"),
    PASSWORD_ERROR(402, "登录失败,用户不存在"),
    UN_AUTH(403, "无权限"),
    HAS_NAME(406,"收藏名称已存在"),
    SUCCESS(200, "成功");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.message;
    }
}

