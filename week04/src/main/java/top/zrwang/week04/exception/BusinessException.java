package top.zrwang.week04.exception;

import lombok.Getter;

/**
 * @author Lenovo
 */
@Getter
public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
}