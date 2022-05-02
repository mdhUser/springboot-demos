package org.maxwell.webdemo.advice.error;

import lombok.Getter;
import lombok.Setter;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/2 15:37
 */

@Getter
@Setter
public class SystemException extends RuntimeException {

    private Integer code;
    private String message;

    public SystemException(Integer code,String message) {
        super(message);
        this.code=code;
        this.message=message;
    }

    public SystemException(Integer code,String message, Throwable cause) {
        super(message, cause);
        this.message=message;
        this.code=code;
    }
}
