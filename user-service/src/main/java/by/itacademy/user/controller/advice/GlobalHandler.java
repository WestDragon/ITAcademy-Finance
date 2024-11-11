package by.itacademy.user.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    public ResponseEntity<?> handle(IllegalArgumentException ex){
        Map<String, String> error = new HashMap<>(); //Переделать на собственное ДТО
        error.put("logref", "error");
        error.put("message", ex.getMessage());

        List<Map<String, String>> errors = new ArrayList<>();
        errors.add(error);

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<?> handle(Exception ex){
        Map<String, String> error = new HashMap<>(); //Переделать на собственное ДТО
        error.put("logref", "error");
        error.put("message", "Сервер не смог корректно обработать запрос. Пожалуйста обратитесь к администратору");

        List<Map<String, String>> errors = new ArrayList<>();
        errors.add(error);

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
