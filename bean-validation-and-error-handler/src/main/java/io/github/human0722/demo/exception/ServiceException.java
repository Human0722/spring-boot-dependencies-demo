package io.github.human0722.demo.exception;

/**
 * @author xueliang
 * @date 2022-12-08 15:26
 */
public class ServiceException extends RuntimeException {
    private int code;

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}