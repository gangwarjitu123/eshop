package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:message.properties")
public class MessageProperties {

	@Value("${notBlank}")
	private String notBlank;
	@Value("${invalidPayload}")
	private String invalidPayload;
	@Value("${invalidValue}")
	private String invalidValue;
	
	@Value("${invalidType}")
	private String invalidType;
	/**
	 * @return the notBlank
	 */
	public String getNotBlank() {
		return notBlank;
	}
	/**
	 * @param notBlank the notBlank to set
	 */
	public void setNotBlank(String notBlank) {
		this.notBlank = notBlank;
	}
	/**
	 * @return the invalidPayload
	 */
	public String getInvalidPayload() {
		return invalidPayload;
	}
	/**
	 * @param invalidPayload the invalidPayload to set
	 */
	public void setInvalidPayload(String invalidPayload) {
		this.invalidPayload = invalidPayload;
	}
	/**
	 * @return the invalidValue
	 */
	public String getInvalidValue() {
		return invalidValue;
	}
	/**
	 * @param invalidValue the invalidValue to set
	 */
	public void setInvalidValue(String invalidValue) {
		this.invalidValue = invalidValue;
	}
	/**
	 * @return the invalidType
	 */
	public String getInvalidType() {
		return invalidType;
	}
	/**
	 * @param invalidType the invalidType to set
	 */
	public void setInvalidType(String invalidType) {
		this.invalidType = invalidType;
	}
	
	
	
}
