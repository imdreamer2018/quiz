package com.twuc.shopping.exception;


import com.twuc.shopping.dto.ExceptionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO ValidationExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        ExceptionDTO r = new ExceptionDTO();
        r.setMessage(e.getMessage());
        r.setCode(400);
        Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
        logger.error("[LOGGING]: " + e.getMessage());
        return r;
    }

    @ExceptionHandler(value = BaseProductException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO ProductNameExistedExceptionHandler(HttpServletRequest req, BaseProductException e) {
        ExceptionDTO r = new ExceptionDTO();
        r.setMessage(e.getMessage());
        r.setCode(400);
        Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
        logger.error("[LOGGING]: " + e.getMessage());
        return r;
    }


}
