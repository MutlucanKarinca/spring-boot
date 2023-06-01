package com.mutlucankarinca.springbootcamp.general;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExcepiton(Exception e, WebRequest webRequest){

        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        GenericErrorMessages genericErrorMessages = new GenericErrorMessages(LocalDateTime.now(), message, description);
        RestResponse<GenericErrorMessages> response = RestResponse.error(genericErrorMessages);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExcepiton(TransactionSystemException e, WebRequest webRequest){

        String message = e.getMessage();
        String description = webRequest.getDescription(false);

        GenericErrorMessages genericErrorMessages = new GenericErrorMessages(LocalDateTime.now(), message, description);
        RestResponse<GenericErrorMessages> response = RestResponse.error(genericErrorMessages);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExcepiton(BusinessException e, WebRequest webRequest){

        String message = e.getBaseErrorMessage().getMessage();
        String description = webRequest.getDescription(false);

        GenericErrorMessages genericErrorMessages = new GenericErrorMessages(LocalDateTime.now(), message, description);
        RestResponse<GenericErrorMessages> response = RestResponse.error(genericErrorMessages);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
