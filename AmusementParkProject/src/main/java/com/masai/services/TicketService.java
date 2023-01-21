package com.masai.services;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.ActivityException;
import com.masai.exception.CustomerException;
import com.masai.exception.TicketException;
import com.masai.model.Ticket;
import com.masai.model.TripBookingDTO;

public interface TicketService {

	public Ticket ticketBooking(Ticket ticket, Integer activity_id)
			throws ActivityException, TicketException, LoginException;

	public Ticket updateTicketBooking(Integer ticket_id, Integer activity_id)
			throws TicketException, ActivityException, LoginException;

	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException, LoginException;

	public List<Ticket> viewAllTicketCustomer()
			throws TicketException, LoginException, CustomerException;

	public TripBookingDTO calculateBill() throws TicketException, LoginException, CustomerException;

}
