package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Ticket;

public interface TicketDao  extends JpaRepository<Ticket, Integer>{
	


}
