package com.gzwork.enums;

/**
 * services日志记录
 *
 * @author Gzwork
 * @version v1.0 2018年8月1日 17:34:19
 */
public enum MsgCodeEnum {
    /**
     * 请求成功
     */
    SUCCESS("SUCCESS", "请求成功"),
    /**
     * 请求参数为空
     */
    PARAMS_NULL("PARAMS_NULL", "请求参数为空"),
    /**
     * 请求参数不合法
     */
    PARAMS_ILLEGAL("PARAMS_ILLEGAL", "请求参数不合法");

    private String code;
    private String msg;

    MsgCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
