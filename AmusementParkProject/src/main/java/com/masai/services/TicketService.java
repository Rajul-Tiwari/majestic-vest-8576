package com.masai.services;

import java.util.List;

import com.masai.exception.ActivityException;
import com.masai.exception.TicketException;
import com.masai.model.Ticket;

public interface TicketService {
	
	public Ticket ticketBooking(Ticket ticket) throws ActivityException, TicketException ;
	
	public Ticket updateTicketBooking(Ticket ticketBooking) throws TicketException;
	
	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException;
	
	public List<Ticket> viewAllTicketCustomer(Integer customerId) throws TicketException;
	
//	public TripBooking calculateBill(Integer customerId)throws TicketException ;

}
