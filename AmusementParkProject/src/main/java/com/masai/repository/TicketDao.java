package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Ticket;

public interface TicketDao  extends JpaRepository<Ticket, Integer>{
	
@Query("select t from Ticket t where t.dateTime=?1")
	public List<Ticket> getTicketByDate(LocalDateTime date);
	@Query("select t from Ticket t where t.dateTime>=?1 and t.dateTime<=?2")
	public List<Ticket> getTicketBetweenDate(LocalDateTime fromDate,LocalDateTime toDate);

}
