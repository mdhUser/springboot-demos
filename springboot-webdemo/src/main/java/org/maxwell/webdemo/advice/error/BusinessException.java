package org.maxwell.webdemo.advice.error;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/2 15:30
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {

    private Integer code;
    private String message;


    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
}
