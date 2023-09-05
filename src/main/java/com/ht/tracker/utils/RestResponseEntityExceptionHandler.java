package com.ht.tracker.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<Object> handleException(
      RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "Something went wrong!";
    log.error("error", ex);
    return handleExceptionInternal(ex, bodyOfResponse,
        new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }
}