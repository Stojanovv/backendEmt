package finki.ukim.mk.lab_1_b.web.handler;

import finki.ukim.mk.lab_1_b.model.exeption.*;
import finki.ukim.mk.lab_1_b.web.controller.AccommodationController;
import finki.ukim.mk.lab_1_b.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = AccommodationController.class)
public class AccommodationControllerExceptionHandler {
    @ExceptionHandler(HostNotFoundExeption.class)
    public ResponseEntity<ApiError> authorNotFound(HostNotFoundExeption exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(AccommodationNotFoundExeption.class)
    public ResponseEntity<ApiError> bookNotFound(AccommodationNotFoundExeption exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}