package top.zrwang.week04.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.zrwang.week04.common.Result;
import top.zrwang.week04.exception.BusinessException;

/**
 * @author Lenovo
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> businessException(BusinessException e) {
        return Result.error(e.getCode(), e.getMessage());
    }

    /**
     * 兜底异常
     */
    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception e) {
        return Result.error(500, "服务器异常，请稍后重试");
    }
}