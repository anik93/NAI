package com.simpleproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

	@ExceptionHandler(Exception.class)
	public String error(HttpServletRequest request, Throwable ex) {
		return "/";
	}
}
