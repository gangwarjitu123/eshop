package com.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class TicketCreationResponse {
	
	private String ticket;
	private String createdBy;
	private String ticketDescription;
	private String ticketStatus;
	private Date assignmentTime;
	/**
	 * @return the ticket
	 */
	public String getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the ticketDescription
	 */
	public String getTicketDescription() {
		return ticketDescription;
	}
	/**
	 * @param ticketDescription the ticketDescription to set
	 */
	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}
	/**
	 * @return the ticketStatus
	 */
	public String getTicketStatus() {
		return ticketStatus;
	}
	/**
	 * @param ticketStatus the ticketStatus to set
	 */
	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	/**
	 * @return the assignmentTime
	 */
	public Date getAssignmentTime() {
		return assignmentTime;
	}
	/**
	 * @param assignmentTime the assignmentTime to set
	 */
	public void setAssignmentTime(Date assignmentTime) {
		this.assignmentTime = assignmentTime;
	}
	
	
	

}
