package com.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mssg;
	private String detailedMsg;
	private String fieldName;
	private HttpStatus httpStatus;

	public CustomException(String mssg,String detailedMsg,String fieldName,HttpStatus httpStatus) {
		this.mssg= mssg;
		this.detailedMsg=detailedMsg;
		this.fieldName= fieldName;
		this.httpStatus=httpStatus;
		
	}

	/**
	 * @return the mssg
	 */
	public String getMssg() {
		return mssg;
	}

	/**
	 * @param mssg the mssg to set
	 */
	public void setMssg(String mssg) {
		this.mssg = mssg;
	}

	/**
	 * @return the detailedMsg
	 */
	public String getDetailedMsg() {
		return detailedMsg;
	}

	/**
	 * @param detailedMsg the detailedMsg to set
	 */
	public void setDetailedMsg(String detailedMsg) {
		this.detailedMsg = detailedMsg;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * @return the httpStatus
	 */


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	
	

}
