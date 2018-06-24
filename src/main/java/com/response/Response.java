package com.response;
import java.util.List;

import com.entity.Ticket;
import com.error.ApiError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Response {
	String mssg;
	private Integer httStatus;
	
	private List<Ticket> list;
	
	@JsonProperty("ticket")
	private TicketCreationResponse ticketCreationResponse;
	@JsonProperty("error")
	private ApiError apiError;
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
	 * @return the httStatus
	 */

	/**
	 * @return the ticketCreationResponse
	 */
	public TicketCreationResponse getTicketCreationResponse() {
		return ticketCreationResponse;
	}
	/**
	 * @param ticketCreationResponse the ticketCreationResponse to set
	 */
	public void setTicketCreationResponse(TicketCreationResponse ticketCreationResponse) {
		this.ticketCreationResponse = ticketCreationResponse;
	}
	/**
	 * @return the apiError
	 */
	public ApiError getApiError() {
		return apiError;
	}
	/**
	 * @param apiError the apiError to set
	 */
	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}
	/**
	 * @return the httStatus
	 */
	public Integer getHttStatus() {
		return httStatus;
	}
	/**
	 * @param httStatus the httStatus to set
	 */
	public void setHttStatus(Integer httStatus) {
		this.httStatus = httStatus;
	}
	/**
	 * @return the list
	 */
	public List<Ticket> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<Ticket> list) {
		this.list = list;
	}
	
	

}
