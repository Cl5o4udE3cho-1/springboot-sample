package top.mqxu.vo;

public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(200, "success", data);
    }

    public static <T> ResultVO<T> success(String msg, T data) {
        return new ResultVO<>(200, msg, data);
    }

    public static <T> ResultVO<T> error(Integer code, String msg) {
        return new ResultVO<>(code, msg, null);
    }

    public static <T> ResultVO<T> error(String msg) {
        return new ResultVO<>(500, msg, null);
    }

    // Getters and Setters
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
}
