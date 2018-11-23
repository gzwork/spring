package com.gzwork.ctrl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author Gzwork
 * @version v1.0 2018年8月1日 17:34:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(ConstraintViolationException e) {
        for (ConstraintViolation<?> s : e.getConstraintViolations()) {
            return s.getPropertyPath().toString() + ": " + s.getMessage();
        }
        return "请求参数不合法";
    }
}