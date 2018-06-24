package com.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.entity.Ticket;
import com.response.Response;
import com.response.TicketCreationResponse;

@Component
public class ResponseGenerator {

	public Response getResponse(Ticket ticket)
	{
		Response response= new Response();
		response.setMssg("ticket created successfylly");
		response.setHttStatus(HttpStatus.OK.value());
		TicketCreationResponse ticketCreationResponse = new TicketCreationResponse();
		ticketCreationResponse.setCreatedBy(ticket.getCreatedBy());
		ticketCreationResponse.setTicket(ticket.getTicketValue());
		ticketCreationResponse.setTicketDescription("this is available to assigne");
		ticketCreationResponse.setTicketStatus("open");
		response.setTicketCreationResponse(ticketCreationResponse);
		return response;
	}

	public Response getAssignedTicketResponse(Ticket dbticket) {
		
		Response response= new Response();
		response.setMssg("ticket assigned successfylly");
		response.setHttStatus(HttpStatus.OK.value());
		TicketCreationResponse ticketCreationResponse = new TicketCreationResponse();
		ticketCreationResponse.setCreatedBy(dbticket.getCreatedBy());
		ticketCreationResponse.setTicket(dbticket.getTicketValue());
		ticketCreationResponse.setTicketDescription("this ticket has been assigned to "+dbticket.getAssignedTo());
		ticketCreationResponse.setTicketStatus(dbticket.getTicketStatus());
		ticketCreationResponse.setAssignmentTime(dbticket.getAssignmentTime());
		response.setTicketCreationResponse(ticketCreationResponse);
		return response;
	}

	public Response getStatusChaneTicketResponse(Ticket dbTicket) {
		Response response= new Response();
		response.setMssg("ticket assigned successfylly");
		response.setHttStatus(HttpStatus.OK.value());
		TicketCreationResponse ticketCreationResponse = new TicketCreationResponse();
		ticketCreationResponse.setCreatedBy(dbTicket.getCreatedBy());
		ticketCreationResponse.setTicket(dbTicket.getTicketValue());
		ticketCreationResponse.setTicketDescription("this ticket has been closed by "+dbTicket.getCloseBy());
		ticketCreationResponse.setTicketStatus(dbTicket.getTicketStatus());
		response.setTicketCreationResponse(ticketCreationResponse);
		return response;
	}
}
