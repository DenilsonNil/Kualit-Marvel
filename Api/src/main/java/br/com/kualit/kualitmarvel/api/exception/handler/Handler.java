package br.com.kualit.kualitmarvel.api.exception.handler;

import lombok.val;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    ProblemDetail handleCharacterNotFound(NoSuchElementException e) {
        val problemDetail = ProblemDetail.forStatusAndDetail(INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        problemDetail.setTitle("Error to get the character");
        problemDetail.setDetail("Character not found");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }
}
