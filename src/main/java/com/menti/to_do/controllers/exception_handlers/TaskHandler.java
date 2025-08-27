package com.menti.to_do.controllers.exception_handlers;

import com.menti.to_do.exceptions.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class TaskHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> catchNotFound(TaskNotFoundException e) {
        String message = e.getMessage();
        log.error("Вызвано исключение {} с сообщением: {}", e.getClass().getSimpleName(), message);
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .body(message);
    }

}
