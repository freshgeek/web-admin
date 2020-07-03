package com.demo.webadmin.common;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 接口返回状态码
 * YangKuo 2018/8/20 15:35
 */
public class ResultCodeMsg {

    public static final int CODE_SUCCESS = 200; // 成功

    public static final int CODE_BAD_REQUEST = 400; //无效请求

    public static final int CODE_UNAUTHORIZED = 403; //无权限

    public static final int CODE_EXCEPTION = 500; // 异常

    public static final int CODE_UPDATE_ERROR = 503; // 修改失败

    public static final int CODE_DATA_IS_NULL = 501; //数据为空

    public static final int CODE_ERROR_USER_NOT_LOGIN = 600; //未登陆

    public static final int CODE_ERROR_USER_SIGN_ERROR = 700; //签名验证失败

    public static final int CODE_ERROR_USER_CALL_LIMITED = 800; //用户调用次数超限


    /**
     * 新的错误码统一按照这个格式 xx x xxx
     **/
    public static final int VALIDATE_CODE_EXPIRE = 300100; //验证码过期或不存在

    public static final int VALIDATE_CODE_INCORRECT = 300101; //验证码错误

    /**
     * 弘康用到的错误码
     */
    public static final int INSURANCE_DEALING = 360100; //保单处理中


    public static String getMsg(int code) {

        String value = CodeMessage.HASH.get(code);
        if (value == null) {
            value = code + "";
        }
        return value;
    }

    public static String getMsgs(int... codes) {

        String[] array = new String[codes.length];
        for (int i = 0; i < codes.length; i++) {
            array[i] = getMsg(codes[i]);
        }
        return Arrays.toString(array);
    }

    private static class CodeMessage extends HashMap<Integer, String> {

        private static final long serialVersionUID = 1L;
        private static final CodeMessage HASH = new CodeMessage();

        static {
            //基础code
            HASH.put(CODE_SUCCESS, "ok");
            HASH.put(CODE_BAD_REQUEST, "错误的请求");
            HASH.put(CODE_EXCEPTION, "系统正忙，请稍后再试");
            HASH.put(CODE_ERROR_USER_NOT_LOGIN, "未登录");
            HASH.put(CODE_DATA_IS_NULL, "数据为空");
            HASH.put(CODE_UNAUTHORIZED, "无权限");

            HASH.put(VALIDATE_CODE_EXPIRE, "验证码已过期");
            HASH.put(VALIDATE_CODE_INCORRECT, "验证码错误");
            HASH.put(INSURANCE_DEALING, "订单处理中");
            HASH.put(CODE_ERROR_USER_SIGN_ERROR, "验签失败");

        }
    }
}
