package com.sailing.lianxi.entity;

public class ReturnMessage {

    /**
     * 返回数据
     */
    private Object data;
    /**
     * 应答编码
     * 0：接口参数错误；1：调用成功
     */
    private Integer respCode;

    public ReturnMessage() {
        super();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }
}
