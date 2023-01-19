package com.masai.services;

import com.masai.exception.ActivityException;
import com.masai.exception.TicketException;
import com.masai.model.Ticket;

public interface TicketService {
	
	public Ticket ticketBooking(Ticket ticket) throws ActivityException, TicketException ;

}
