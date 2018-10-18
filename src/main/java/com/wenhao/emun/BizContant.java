package com.wenhao.emun;

public enum BizContant {
    RESP_CODE_0("0","success"),
    RESP_CODE_1("1","手机号不能为空"),
    RESP_CODE_2("2","密码不能为空"),
    RESP_CODE_3("3","手机号格式有误"),
    RESP_CODE_4("4","用户名或密码错误"),
    
    RESP_CDOE_9("9","系统异常")
    ;
    private String msg;
    private String code;

    BizContant(String code, String msg) {
    	this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}
