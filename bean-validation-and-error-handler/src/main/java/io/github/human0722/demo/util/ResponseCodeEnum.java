package io.github.human0722.demo.util;

/**
 * @author xueliang
 * @description TODO
 * @date 2022-12-08 15:29
 */
public enum ResponseCodeEnum {

    OK(200, "ok"),
    NOT_FOUND(404, "Not Found"),
    FORBIDDEN(403, "Forbidden"),
    PARAMETER_ERROR(400, "Parameter Error"),
    INNER_ERROR(500, "Server Inner Error");

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
