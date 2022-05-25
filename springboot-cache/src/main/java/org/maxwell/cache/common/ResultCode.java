package org.maxwell.cache.common;

/**
 * @author itheima
 * code 返回状态码
 */
public enum  ResultCode implements IErrorCode{
    //操作成功
    SUCCESS(200, "操作成功"),
    //失败
    FAILED(500, "操作失败"),
    //参数错误
    VALIDATE_FAILED(404, "参数检验失败"),
    //身份过期或未登录
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    //没有权限
    FORBIDDEN(403, "没有相关权限");
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}