package com.shan.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandle {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorInfo> myInvalidDataExpHandler(MethodArgumentNotValidException me) {
		
		MyErrorInfo err = new MyErrorInfo();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(me.getBindingResult().getFieldError().getDefaultMessage());
		
		
		return new ResponseEntity<MyErrorInfo>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorInfo> myAnyExpHandler(Exception ie,WebRequest req){
		
		
		MyErrorInfo err = new MyErrorInfo();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorInfo>(err, HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorInfo> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {
			
	
		MyErrorInfo err=new MyErrorInfo(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
					
	}

	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorInfo> myAnyExpHandler(UserException ie,WebRequest req){
		
		
		MyErrorInfo err = new MyErrorInfo();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorInfo>(err, HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(MailNotFoundException.class)
	public ResponseEntity<MyErrorInfo> myAnyExpHandler(MailNotFoundException ie,WebRequest req){
		
		
		MyErrorInfo err = new MyErrorInfo();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorInfo>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorInfo> myAnyExpHandler(LoginException ie,WebRequest req){
		
		
		MyErrorInfo err = new MyErrorInfo();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(req.getDescription(false));
		
		
		return new ResponseEntity<MyErrorInfo>(err, HttpStatus.BAD_REQUEST);
		
	}
	
}