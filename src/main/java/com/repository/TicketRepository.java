package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>  {

	public Ticket findByIdAndType(Integer id, String type);

	public Optional<Ticket> findByTypeAndTicketStatus(String type, String status);

	public Optional<Ticket> findByTicketStatus(String status);

	public List<Ticket> findByDepartmentIdAndType(Integer id, String type);

	public List<Ticket> findByEmployeeIdAndType(Integer id, String type);

}
