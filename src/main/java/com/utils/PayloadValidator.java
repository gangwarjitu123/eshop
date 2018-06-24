package com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.config.ApplicationProperties;
import com.config.MessageProperties;
import com.entity.Ticket;
import com.exception.CustomException;

@Component
public class PayloadValidator {
	@Autowired
	ApplicationProperties applicationProperties;

	@Autowired
	MessageProperties messageProperties;

	public void validatePayload(Ticket ticket) {
		if ((!ticket.getType().equalsIgnoreCase(applicationProperties.getManagerType()))
				&& (!ticket.getType().equalsIgnoreCase(applicationProperties.getDepartmenttype()))
				&& (!ticket.getType().equalsIgnoreCase(applicationProperties.getEmployee()))) {
			throw new CustomException(messageProperties.getInvalidValue(), messageProperties.getInvalidType(), "type",
					HttpStatus.BAD_REQUEST);

		}
	}

	public void validatePayload(String type, String id) {

		if ((!type.equalsIgnoreCase(applicationProperties.getManagerType()))
				&& (!type.equalsIgnoreCase(applicationProperties.getDepartmenttype()))
				&& !type.equalsIgnoreCase(applicationProperties.getEmployee())) {
			throw new CustomException(messageProperties.getInvalidValue(), messageProperties.getInvalidValue(), "type",
					HttpStatus.BAD_REQUEST);

		}

		if (id == null || id.length() == 0) {
			throw new CustomException(messageProperties.getInvalidValue(), messageProperties.getInvalidValue(), "id",
					HttpStatus.BAD_REQUEST);
		}
	}

	public void validatePayload(String status, String id, String object) {
		if ((!status.equalsIgnoreCase(applicationProperties.getClose()))
				&& (!status.equalsIgnoreCase(applicationProperties.getOpen()))) {
			throw new CustomException(messageProperties.getInvalidValue(), messageProperties.getInvalidValue(),
					"status", HttpStatus.BAD_REQUEST);

		}

		if (id == null || id.length() == 0) {
			throw new CustomException(messageProperties.getInvalidValue(), messageProperties.getInvalidValue(), "id",
					HttpStatus.BAD_REQUEST);
		}
	}

}
