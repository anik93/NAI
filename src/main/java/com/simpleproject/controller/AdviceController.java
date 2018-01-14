package com.simpleproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class AdviceController {

	@ExceptionHandler(NoHandlerFoundException.class)
	public String noURL(HttpServletRequest request, Throwable ex) {
		return "/";
	}

	@ExceptionHandler(Exception.class)
	public String error(HttpServletRequest request, Throwable ex) {
		return "/";
	}
}
