package org.maxwell.mybatis.entity.response;

import lombok.Builder;
import lombok.Data;
import org.maxwell.mybatis.util.ResponseStatus;

import java.io.Serializable;

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
                .status(ResponseStatus.SUCCESS.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }


    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseResult<T> fail(String message) {
          return fail(null,message);
    }


    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().data(data)
                .message(message)
                .status(ResponseStatus.FAIL.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

}
