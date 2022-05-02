package org.maxwell.webdemo.model.dto;

import lombok.Builder;
import lombok.Data;
import org.maxwell.webdemo.constant.ResponseStatus;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/2 20:20
 */
@Data
@Builder
public class ResponseResult<T> {

    private long timestamp;

    private Integer status;

    private String message;

    private T data;

    public static <T> ResponseResult<T> success() {
        return success(null);
    }


    /**
     * response success result wrapper.
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .message(ResponseStatus.SUCCESS.getDescription())
                .status(ResponseStatus.SUCCESS.getCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }


    /**
     *
     * @param message
     * @return
     */
    public static ResponseResult<Integer> fail(String message) {
          return fail(ResponseStatus.FAIL.getCode(), message);
    }


    /**
     *
     * @param code
     * @param message
     * @return
     */
    public static  ResponseResult<Integer> fail(Integer code, String message) {
        return ResponseResult.<Integer>builder().status(code)
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
    }

}
