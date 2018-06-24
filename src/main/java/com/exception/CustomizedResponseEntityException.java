package com.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.error.ApiError;
import com.response.Response;

@ControllerAdvice
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler{
	
	@Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Response response = new Response();
		response.setHttStatus(status.BAD_REQUEST.value());
		response.setMssg("Please enter mandatory data and also in valid format");
		ApiError apiError = new ApiError();
		apiError.setFieldName(ex.getBindingResult().getFieldError().getField());
		apiError.setDebugMssg(ex.getMessage());
		apiError.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		apiError.setObjectName(ex.getBindingResult().getObjectName());
		response.setApiError(apiError);
		return new ResponseEntity<Object>(response,status);
       
    }
	
	
	
	    @ExceptionHandler(CustomException.class)
	    public final ResponseEntity<Object> customException(CustomException ex,  WebRequest request) {
	    	
	    	Response response = new Response();
			response.setHttStatus(ex.getHttpStatus().value());
			response.setMssg("Please enter mandatory data and also in valid format");
			ApiError apiError = new ApiError();
			apiError.setFieldName(ex.getFieldName());
			apiError.setDebugMssg(ex.getMessage());
			apiError.setMessage(ex.getDetailedMsg());
			apiError.setObjectName(ex.getFieldName());
			response.setApiError(apiError);
			return new ResponseEntity<Object>(response,ex.getHttpStatus());
			
	       

	    }

	
}
