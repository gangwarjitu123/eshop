package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Ticket;
import com.response.Response;
import com.service.TicketService;

@RestController
@RequestMapping("/v0.1")
public class TicketController {
	@Autowired
	TicketService ticketService;
	@RequestMapping(value="/createTicket",method=RequestMethod.POST,consumes = "application/json",produces="application/json")
	public ResponseEntity<Response> createTicket(@Valid @RequestBody Ticket ticket )
	{
		Response ticketCreationResponse=ticketService.createTicket(ticket);
		return new ResponseEntity<Response>(ticketCreationResponse,HttpStatus.OK);
		
	}
	@GetMapping("/assignedTicket/{id}/{type}")
	public ResponseEntity<Response> assignedTicket(@PathVariable("id") Integer id, @ PathVariable("type") String type)
	{
		Response assignedTicketResponse=ticketService.assignedTicket(id,type);
		return new ResponseEntity<Response>(assignedTicketResponse,HttpStatus.OK);
		
	}

	
	@GetMapping("/changeTicketSatus/{ticketId}/{satus}/{closedBy}")
	public ResponseEntity<Response> changeTicketSatus(@PathVariable("ticketId") Integer id, @PathVariable("status") String status,@PathVariable("closedBy") String closedBy)
	{
		Response changeTicketSatusResponse=ticketService.changeTicketSatus(id,status,closedBy);
		return new ResponseEntity<Response>(changeTicketSatusResponse,HttpStatus.OK);
		
	}

	
	
	@GetMapping("/findpendingticketfordepartment/{departmentId}/{type}")
	public ResponseEntity<Response> findPendingTicketforDepartment(@PathVariable("departmentId") Integer id, @PathVariable("type") String type)
	{
		Response changeTicketSatusResponse=ticketService.findPendingTicketforDepartment(id,type);
		return new ResponseEntity<Response>(changeTicketSatusResponse,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/findPendingTicketformanager/{managerId}/{type}")
	public ResponseEntity<Response> findPendingTicketforManager(@PathVariable("managerId") Integer id, @PathVariable("type") String type)
	{
		Response changeTicketSatusResponse=ticketService.findPendingForManagerTicket(id,type);
		return new ResponseEntity<Response>(changeTicketSatusResponse,HttpStatus.OK);
		
	}

}
