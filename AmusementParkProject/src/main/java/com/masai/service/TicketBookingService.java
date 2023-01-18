package com.masai.service;

import java.util.List;

import com.masai.exception.TicketBookingException;
import com.masai.model.Ticket;

public interface TicketBookingService {
	
	public Ticket insertTicketBooking(Ticket ticketBooking) throws TicketBookingException;
	
	public Ticket updateTicketBooking(Ticket ticketBooking) throws TicketBookingException;
	
	public Ticket deleteTicketBooking(Integer ticketId) throws TicketBookingException;
	
	public List<Ticket> viewAllTicketCustomer(Integer customerId) throws TicketBookingException;
	
//	public TripBooking calculateBill(Integer customerId)throws TicketBookingException ;
	
}

