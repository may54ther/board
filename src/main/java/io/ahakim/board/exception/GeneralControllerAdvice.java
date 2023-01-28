package io.ahakim.board.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice("io.ahakim.board.controller")
public class GeneralControllerAdvice {

    @ExceptionHandler({PostNotFoundException.class})
    public String handleCustomException(PostNotFoundException e, Model model) {
        model.addAttribute("msg", e.getMessage());
        model.addAttribute("url", "/posts");
        return "views/common/messageAlert";
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public void handleException(Exception e) {
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
    }
}
