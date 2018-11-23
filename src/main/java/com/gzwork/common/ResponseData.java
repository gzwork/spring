package com.gzwork.common;

import com.gzwork.enums.MsgCodeEnum;

/**
 * 返回前端的数据
 *
 * @author Gzwork
 * @version v1.0 2018年8月1日 11:39:24
 */
public class ResponseData {

    /**
     * 前端所需数据
     */
    private Object data;

    /**
     * 请求code
     */
    private String code;
    /**
     * 附加信息
     */
    private String msg;

    public ResponseData() {

    }


    public ResponseData(Object data) {
        this.data = data;
        this.code = MsgCodeEnum.SUCCESS.getCode();
        this.msg = MsgCodeEnum.SUCCESS.getMsg();
    }

    public ResponseData(MsgCodeEnum msgCodeEnum) {
        this.code = msgCodeEnum.getCode();
        this.msg = msgCodeEnum.getMsg();
    }

    public ResponseData(Object data, MsgCodeEnum msgCodeEnum) {
        this.data = data;
        this.code = msgCodeEnum.getCode();
        this.msg = msgCodeEnum.getMsg();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
