package jeff.code.jm23899gpt.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }

}
