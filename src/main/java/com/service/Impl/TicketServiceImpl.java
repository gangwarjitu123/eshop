package com.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.config.ApplicationProperties;
import com.config.MessageProperties;
import com.entity.Department;
import com.entity.Employee;
import com.entity.Ticket;
import com.exception.CustomException;
import com.repository.DepartmentRepository;
import com.repository.EmployeeRepository;
import com.repository.TicketRepository;
import com.response.Response;
import com.response.TicketCreationResponse;
import com.service.TicketService;
import com.utils.CreateTicketUtils;
import com.utils.PayloadValidator;
import com.utils.ResponseGenerator;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	ResponseGenerator responseGenerator;

	@Autowired
	ApplicationProperties applicationProperties;

	@Autowired
	DepartmentRepository DepartmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PayloadValidator payloadValidator;
	@Autowired
	MessageProperties messageProperties;

	@Override
	public Response createTicket(Ticket ticket) {
		payloadValidator.validatePayload(ticket);
		ticket.setTicketValue(CreateTicketUtils.createTicket());
		ticket.setTicketStatus(applicationProperties.getOpen());
		Optional<Ticket> responseTicket = Optional.ofNullable(ticketRepository.save(ticket));
		Ticket dbTicket = responseTicket
				.orElseThrow(() -> new CustomException("something went wrong", "internal server error", "ticket	", HttpStatus.GATEWAY_TIMEOUT));
		return responseGenerator.getResponse(dbTicket);
	}

	@Override
	public Response assignedTicket(Integer id, String type) {
		payloadValidator.validatePayload(type, Integer.toString(id));
		Optional<Ticket> ticketOptional = ticketRepository.findByTypeAndTicketStatus(type,"open");
		Ticket ticket = ticketOptional.orElseThrow(() -> new CustomException("ticket is not available to assigned",
				"ticket is not available to assigned so first create the ticket for given type", "",
				HttpStatus.NOT_FOUND));

		if (type.equalsIgnoreCase(applicationProperties.getManagerType())) {
			Optional<Employee> empOptional = Optional
					.ofNullable(employeeRepository.findByIdAndDesignation(Integer.valueOf(id), type));
			Employee employee = empOptional.orElseThrow(() -> new CustomException("manager id is invalid",
					"manager id is invalid or given employee id designation not a manager ", "id", HttpStatus.BAD_REQUEST));
			ticket.setAssignedTo(employee.getName());
			ticket.setEmployeeId(employee.getId());

		} else if (type.equalsIgnoreCase(applicationProperties.getDepartmenttype())) {
			Optional<Department> deptOptional = DepartmentRepository.findById(Integer.valueOf(id));
			Department department = deptOptional.orElseThrow(() -> new CustomException("department id is invalid",
					"department id is invalid", "id", HttpStatus.BAD_REQUEST));

			ticket.setAssignedTo(department.getName());
			ticket.setDepartmentId(department.getId());

		} else if (type.equalsIgnoreCase(applicationProperties.getEmployee())) {
			Optional<Employee> empOptional = employeeRepository.findById(Integer.valueOf(id));
			Employee employee = empOptional.orElseThrow(() -> new CustomException("employee id is invalid",
					"employee id is invalid", "id", HttpStatus.BAD_REQUEST));

			ticket.setAssignedTo(employee.getName());
			ticket.setEmployeeId(employee.getId());
		}

		ticket.setTicketStatus(applicationProperties.getAssigned());
		ticket.setAssignmentTime(new Date());
		Ticket dbticket=ticketRepository.save(ticket);

		return responseGenerator.getAssignedTicketResponse(dbticket);
	}

	@Override
	public Response changeTicketSatus(Integer id, String status,String closedBy) {
		payloadValidator.validatePayload(status, Integer.toString(id));
		Optional<Ticket> ticketOptional = ticketRepository.findById(id);
		Ticket ticket = ticketOptional.orElseThrow(() -> new CustomException("invalid ticket id",
				"invalid ticket id", "id",
				HttpStatus.NOT_FOUND));
		ticket.setTicketStatus(status);
		ticket.setClosingTime(new Date());
		ticket.setCloseBy(closedBy);
		Ticket dbTicket=ticketRepository.save(ticket);
		return responseGenerator.getStatusChaneTicketResponse(dbTicket);
	}

	@Override
	public Response findPendingTicketforDepartment(Integer id, String type) {
		payloadValidator.validatePayload(type, Integer.toString(id));
	    List<Ticket> list=	ticketRepository.findByDepartmentIdAndType(id,type);
	    Response response = new Response(); 
	    response.setHttStatus(HttpStatus.OK.value());
	    response.setMssg("ticket details fatch successfully");;
	    response.setList(list);
	    
		return response;
	}
	
	
	@Override
	public Response findPendingForManagerTicket(Integer id, String type) {
		payloadValidator.validatePayload(type, Integer.toString(id));
	    List<Ticket> list=	ticketRepository.findByEmployeeIdAndType(id,type);
	    Response response = new Response(); 
	    response.setHttStatus(HttpStatus.OK.value());
	    response.setMssg("ticket details fatch successfully");;
	    response.setList(list);
	    
		return response;
	}

}
