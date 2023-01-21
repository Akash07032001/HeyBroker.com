package com.masai.heybroker.exception;

import com.masai.heybroker.model.Broker;
import com.masai.heybroker.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<MyErrorDetails>customerExceptionHandler(CustomerException ce, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ce.getMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<MyErrorDetails>adminExceptionHandler(AdminException ae, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ae.getMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyException.class)
    public ResponseEntity<MyErrorDetails>propertyNotFountExceptionHandler(PropertyException me, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),me.getMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DealException.class)
    public ResponseEntity<MyErrorDetails>dealNotFoundExceptionHandler(DealException de, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),de.getMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BrokerException.class)
    public ResponseEntity<MyErrorDetails>brokerExceptionHandler(BrokerException be, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),be.getMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails>genericExceptionHandler(Exception e, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),e.getMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyErrorDetails>noHandlerExceptionHandler(NoHandlerFoundException ne, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),ne.getMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails>methodArgumentExceptionHandler(MethodArgumentNotValidException me, WebRequest req){

        MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),me.getBindingResult().getFieldError().getDefaultMessage(),req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
}
