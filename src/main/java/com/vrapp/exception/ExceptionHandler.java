package com.vrapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody Error handleNotFoundException(final Exception exception){
		return new Error(exception.getMessage(), HttpStatus.NOT_FOUND.value());
	}

}
