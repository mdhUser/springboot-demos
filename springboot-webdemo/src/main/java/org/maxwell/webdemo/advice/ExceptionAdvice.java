package org.maxwell.webdemo.advice;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.webdemo.advice.error.BusinessException;
import org.maxwell.webdemo.advice.error.SystemException;
import org.maxwell.webdemo.model.dto.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/2 11:38
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public ResponseResult<Integer> exceptionHandler(Exception e) {
        log.error("[未知异常]{}", e.getMessage());
        return ResponseResult.fail(4444, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseResult<Integer> businessExceptionHandler(BusinessException e) {
        log.error("[业务异常]{}", e.getMessage());
        return ResponseResult.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public ResponseResult<Integer> systemExceptionHandler(SystemException e) {
        log.error("[系统异常]{}", e.getMessage());
        return ResponseResult.fail(e.getCode(), e.getMessage());
    }


}
