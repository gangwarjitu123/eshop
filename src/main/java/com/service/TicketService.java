package com.service;

import org.springframework.stereotype.Service;

import com.entity.Ticket;
import com.response.Response;

@Service
public interface TicketService {
	
	public Response createTicket(Ticket ticket);
	public Response assignedTicket(Integer id ,String type);
	public Response changeTicketSatus(Integer id, String status,String closedBy);
	public Response findPendingTicketforDepartment(Integer id, String type);
	public Response findPendingForManagerTicket(Integer id, String type);

}
