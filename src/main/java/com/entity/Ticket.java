package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Jitendra.Kumar
 * created date -23/06/2018
 *
 */
@Entity
@Table(name="ticket")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message="{notBlank}")
	private String summary;
	private String description;
	@NotNull(message="{notBlank}")
	private String type;   // for mngr  or dept  only
	@NotNull(message="{notBlank}")
	private String createdBy;
	@CreationTimestamp
	private Date creationTime;
	private String assignedTo;
	private Date assignmentTime;
	private String closeBy;
	private String ticketValue;
	
	private Integer employeeId;
	private Integer departmentId;
	
	private String ticketStatus; // open  assigned close
	
	private Date closingTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getCloseBy() {
		return closeBy;
	}
	public void setCloseBy(String closeBy) {
		this.closeBy = closeBy;
	}
	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
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
	/**
	 * @return the closingTime
	 */
	public Date getClosingTime() {
		return closingTime;
	}
	/**
	 * @param closingTime the closingTime to set
	 */
	public void setClosingTime(Date closingTime) {
		this.closingTime = closingTime;
	}
	/**
	 * @return the tickeValue
	 */
	/**
	 * @return the ticketValue
	 */
	public String getTicketValue() {
		return ticketValue;
	}
	/**
	 * @param ticketValue the ticketValue to set
	 */
	public void setTicketValue(String ticketValue) {
		this.ticketValue = ticketValue;
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
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}
	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}


	
	
	
	

}
