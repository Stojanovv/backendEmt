package finki.ukim.mk.lab_1_b.web.handler;

import finki.ukim.mk.lab_1_b.model.exeption.CountryNotFoundExeption;
import finki.ukim.mk.lab_1_b.web.controller.CountryController;
import finki.ukim.mk.lab_1_b.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = CountryController.class)
public class CountryControllerExceptionHandler {
    @ExceptionHandler(CountryNotFoundExeption.class)
    public ResponseEntity<ApiError> countryNotFound(CountryNotFoundExeption exception) {
        System.out.println(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}