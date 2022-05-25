package org.maxwell.cache.common;

/**
 * @author itheima
 * code  错误码接口定义
 */
public interface IErrorCode {
    /**
     * 获取状态码
     */
    long getCode();

    /**
     * 获取提示信息
     */
    String getMessage();
}
