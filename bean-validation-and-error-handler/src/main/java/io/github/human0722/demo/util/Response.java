package io.github.human0722.demo.util;

/**
 * @author xueliang
 * @date 2022-12-08 15:27
 */
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public Response() {}

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    static public Response error(String message) {
        return error(400,message);
    }

    static public Response error(int code, String message) {
        return new Response<String>(code, message);
    }

    static public Response success(Object data) {
        return new Response(
                ResponseCodeEnum.OK.getCode(),
                ResponseCodeEnum.OK.getMessage(),
                data);
    }
}
