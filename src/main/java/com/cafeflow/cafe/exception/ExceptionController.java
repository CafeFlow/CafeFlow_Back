package com.cafeflow.cafe.exception;

import com.cafeflow.cafe.domain.CafeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {
    @ResponseBody
    @ExceptionHandler(CafeFlowException.class)
    public ResponseEntity<ErrorResponse> cafeflowException(CafeFlowException e){
        int statusCode = e.getStatusCode();
        ErrorResponse body = ErrorResponse.builder()
                .code(String.valueOf(statusCode))
                .message(e.getMessage()).build();
        return ResponseEntity.status(statusCode).body(body);
    }

}
