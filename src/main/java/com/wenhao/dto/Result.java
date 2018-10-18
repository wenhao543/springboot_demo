package com.wenhao.dto;

public class Result<T> {
    private String code;
    private String msg;
    private T data;

    /**
     * 私有化
     * @param data
     */
    private Result(T data) {
        this.code = "0";
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg bc) {
        this.msg = bc.getMsg();
        this.code = bc.getCode();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMsg cm) {
        return new Result<T>(cm);
    }
}
