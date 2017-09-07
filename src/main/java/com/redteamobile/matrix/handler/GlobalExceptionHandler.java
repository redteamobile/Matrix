package com.redteamobile.matrix.handler;

import com.redteamobile.matrix.constant.ErrorCode;
import com.redteamobile.matrix.exception.BaseException;
import com.redteamobile.matrix.exception.PagerException;
import com.redteamobile.matrix.model.page.ErrorResponseStruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(PagerException.class)
    public ResponseEntity<ErrorResponseStruct> handlePagerException(HttpServletRequest request, BaseException e) {
        //TODO pager logic to add here

        return handleBaseException(request, e);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponseStruct> handleBaseException(HttpServletRequest request,
            BaseException e) {
        ErrorResponseStruct er = new ErrorResponseStruct();
        er.setErrorMsg(e.getErrorMessage());
        er.setErrorCode(e.getErrorCode());

        return ResponseEntity.ok(er);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseStruct> handleUnexpectedException(HttpServletRequest request,
            Exception e) {
        log.error("Unexpected exception received {}!!", e.getMessage());

        e.printStackTrace();
        // TODO write a right response format and properly handle exception

        ErrorResponseStruct er = new ErrorResponseStruct();
        er.setErrorMsg(e.getMessage());
        er.setErrorCode(ErrorCode.UNKNOWN_ISSUE);

        return ResponseEntity.ok().body(er);
    }

}
