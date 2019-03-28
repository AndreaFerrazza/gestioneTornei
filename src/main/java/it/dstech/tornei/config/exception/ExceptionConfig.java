package it.dstech.tornei.config.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { BadRequestException.class })
	ResponseEntity<Object> handle(BadRequestException e, WebRequest request) {
		GenericResponseError error = new GenericResponseError();
		error.setCode(e.getCode());
		error.setMessage(e.getMessage());

		return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = { InternalServerException.class })
	ResponseEntity<Object> handle(InternalServerException e, WebRequest request) {
		GenericResponseError error = new GenericResponseError();
		error.setCode(e.getCode());
		error.setMessage(e.getMessage());

		return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
