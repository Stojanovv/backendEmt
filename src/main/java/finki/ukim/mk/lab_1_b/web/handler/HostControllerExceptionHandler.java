package finki.ukim.mk.lab_1_b.web.handler;

import finki.ukim.mk.lab_1_b.model.exeption.CountryNotFoundExeption;
import finki.ukim.mk.lab_1_b.model.exeption.HostNotFoundExeption;
import finki.ukim.mk.lab_1_b.web.controller.HostController;
import finki.ukim.mk.lab_1_b.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = HostController.class)
public class HostControllerExceptionHandler {
    @ExceptionHandler(HostNotFoundExeption.class)
    public ResponseEntity<ApiError> authorNotFound(HostNotFoundExeption exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(CountryNotFoundExeption.class)
    public ResponseEntity<ApiError> countryNotFound(CountryNotFoundExeption exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}