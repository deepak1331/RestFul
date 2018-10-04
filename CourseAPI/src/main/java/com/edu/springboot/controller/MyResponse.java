package com.edu.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

public class MyResponse<T> {
	
	private HttpStatus httpStatus;
	private String message;
	private List<T> result;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	
	public MyResponse(HttpStatus httpStatus, String message, List<T> result) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.result = result;
	}
	
	
	
	
}
