package com.masai.services;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.controller.UserController;
import com.masai.exception.ActivityException;
import com.masai.exception.CustomerException;
import com.masai.exception.TicketException;
import com.masai.model.Activity;
import com.masai.model.Customer;
import com.masai.model.Ticket;
import com.masai.model.TripBookingDTO;
import com.masai.repository.ActivityDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.TicketDao;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDao tDao;

	@Autowired
	ActivityDao aDao;

	@Autowired
	CustomerDao cDao;

	@Override
	public Ticket ticketBooking(Ticket ticket, Integer activity_id)
			throws ActivityException, TicketException, LoginException {

		if (!UserController.isLogin) {
			throw new LoginException("Please login first");
		}

		Optional<Activity> optActivity = aDao.findById(activity_id);

		if (optActivity.isPresent()) {

			ticket.setCustomer(LoginServiceImpl.customer);
			ticket.setActivity(optActivity.get());

			Ticket tkt = tDao.save(ticket);

			return tkt;

		} else {

			throw new ActivityException("Please enter valid activity ID");

		}

	}

	@Override
	public Ticket updateTicketBooking(Integer ticket_id, Integer activity_id)
			throws TicketException, ActivityException, LoginException {

		if (!UserController.isLogin) {
			throw new LoginException("Please login first");
		}

		Optional<Ticket> optTicket = tDao.findById(ticket_id);

		if (optTicket.isPresent()) {

			Ticket ticket = optTicket.get();
			
			Optional<Activity> optActivity = aDao.findById(activity_id);
			
			if (optActivity.isPresent()) {
				
				ticket.setActivity(optActivity.get());
	
				return tDao.save(ticket);
	
			} else {
			
				throw new ActivityException("Please enter valid activity id");
			
			}

		} else {
			throw new TicketException("Please enter valid ticket id");
		}

	}

	@Override
	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException, LoginException {

		if (!UserController.isLogin) {
			throw new LoginException("Please login first");
		}

		Optional<Ticket> optTicket = tDao.findById(ticketId);

		if (optTicket.isPresent()) {

			tDao.delete(optTicket.get());
			
			return optTicket.get();

		} else {

			throw new TicketException("Please enter valid ticket id");

		}

	}

	@Override
	public List<Ticket> viewAllTicketCustomer()
			throws TicketException, LoginException, CustomerException {

		if (!UserController.isLogin) {
			throw new LoginException("Please login first");
		}

//		Optional<Customer> optCustomer = cDao.findById(customerId);

//		if (optCustomer.isPresent()) {

			List<Ticket> tickets = tDao.getAllTicketsByCustomerId(LoginServiceImpl.customer.getCustomerID());

			if (tickets.isEmpty()) {
				throw new TicketException("Tickets is empty");
			} else {
				return tickets;
			}

//		} else {
//
//			throw new CustomerException("Please enter valid customer id");
//
//		}

	}

	@Override
	public TripBookingDTO calculateBill() throws TicketException, LoginException, CustomerException {

		if (!UserController.isLogin) {
			throw new LoginException("Please login first");
		}

//		Optional<Customer> optCustomer = cDao.findById(customerId);

//		if (optCustomer.isPresent()) {

			TripBookingDTO tripDto = new TripBookingDTO();

			tripDto.setCustomer(LoginServiceImpl.customer);

			List<Ticket> tickets = tDao.getAllTicketsByCustomerId(LoginServiceImpl.customer.getCustomerID());

			tripDto.setTickets(tickets);

			int totalAmount = 0;

			for (Ticket t : tickets) {
				totalAmount += t.getActivity().getCharge();
			}

			tripDto.setTotalAmount(totalAmount);

			return tripDto;

//		} else {
//
//			throw new CustomerException("Please enter valid customer id");
//
//		}

	}
}
