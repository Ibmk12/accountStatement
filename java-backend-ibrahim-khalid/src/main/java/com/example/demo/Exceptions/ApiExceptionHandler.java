//package com.example.demo.Exceptions;
//
//import com.example.demo.ResponseModel.ErrorMessage;
//import com.example.demo.ResponseModel.Messages;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import javax.servlet.ServletException;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeParseException;
//
//@ControllerAdvice
//public class ApiExceptionHandler {
//
//
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<Object> handleNullPointerException(NullPointerException e)
//    {
//        HttpStatus badRequest =  HttpStatus.BAD_REQUEST;
//        ErrorMessage errorMessage = new ErrorMessage(
//                Messages.ACCOUNT_NOT_FOUND.getError(),
//                badRequest,
//                ZonedDateTime.now(ZoneId.of("Z")));
//
//
//        return new ResponseEntity<>(errorMessage,badRequest);
//    }
//
//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<Object> handleNumberFormatException(NumberFormatException e)
//    {
//        HttpStatus badRequest =  HttpStatus.BAD_REQUEST;
//        ErrorMessage errorMessage = new ErrorMessage(
//                Messages.INVALID_NUMBER_FORMAT.getError(),
//                badRequest,
//                ZonedDateTime.now(ZoneId.of("Z")));
//
//        return new ResponseEntity<>(errorMessage,badRequest);
//    }
//
//    @ExceptionHandler(DateTimeParseException.class)
//    public ResponseEntity<Object> handleDateTimeParseException(DateTimeParseException e)
//    {
//        HttpStatus badRequest =  HttpStatus.BAD_REQUEST;
//        ErrorMessage errorMessage = new ErrorMessage(
//                Messages.INVALID_DATE_FORMAT.getError(),
//                badRequest,
//                ZonedDateTime.now(ZoneId.of("Z")));
//
//
//        return new ResponseEntity<>(errorMessage,badRequest);
//    }
//
//    @ExceptionHandler(ApiRequestException.class)
//    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e)
//    {
//        HttpStatus badRequest =  HttpStatus.BAD_REQUEST;
//        ErrorMessage errorMessage = new ErrorMessage(
//                Messages.INVALID_USER_ACCOUNTID.getError(),
//                badRequest,
//                ZonedDateTime.now(ZoneId.of("Z")));
//
//
//        return new ResponseEntity<>(errorMessage,badRequest);
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ResponseEntity<Object> handleAuthorizationException(HttpMessageNotReadableException e)
//    {
//        HttpStatus badRequest =  HttpStatus.BAD_REQUEST;
//        ErrorMessage errorMessage = new ErrorMessage(
//                Messages.INVALID_USER_ACCOUNTID.getError(),
//                badRequest,
//                ZonedDateTime.now(ZoneId.of("Z")));
//
//
//        return new ResponseEntity<>(errorMessage,badRequest);
//    }
//
//}