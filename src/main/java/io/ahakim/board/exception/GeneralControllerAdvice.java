package io.ahakim.board.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice("io.ahakim.board.controller")
public class GeneralControllerAdvice {

    @ExceptionHandler({CustomException.class})
    public void handleCustomException(CustomException e) {
        log.error("Custom exception occurred: {}", e.getMessage(), e);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public void handleException(Exception e) {
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
    }
}
