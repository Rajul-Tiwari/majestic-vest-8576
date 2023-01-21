package com.masai.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ActivityException;
import com.masai.exception.CustomerException;
import com.masai.exception.TicketException;
import com.masai.model.Ticket;
import com.masai.model.TripBookingDTO;
import com.masai.services.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService tService;

	static boolean isLogin = false;

	@PostMapping("/ticketBooking/{activity_id}")
	public ResponseEntity<Ticket> bookticket(@RequestBody Ticket tkt, @PathVariable Integer activity_id)
			throws ActivityException, TicketException, LoginException {

		Ticket ticket = tService.ticketBooking(tkt, activity_id);
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);

	}

	@PutMapping("/ticketBooking/updateTicket/{ticket_id}/{activity_id}")
	public ResponseEntity<Ticket> updateTicketHandler(@PathVariable Integer ticket_id,
			@PathVariable Integer activity_id) throws LoginException, TicketException, ActivityException {

		Ticket ticket = tService.updateTicketBooking(ticket_id, activity_id);

		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	@DeleteMapping("/ticketBooking/deleteTicket/{ticket_id}")
	public ResponseEntity<Ticket> deleteTicketHandler(@PathVariable Integer ticket_id)
			throws LoginException, TicketException {

		Ticket ticket = tService.deleteTicketBooking(ticket_id);

		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getTicketsHandler()throws LoginException, TicketException, CustomerException {

		List<Ticket> tickets = tService.viewAllTicketCustomer();

		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}

	@GetMapping("/calculateBill/{customer_id}")
	public ResponseEntity<TripBookingDTO> getBillHandler()throws LoginException, TicketException, CustomerException {

		TripBookingDTO tripDto = tService.calculateBill();

		return new ResponseEntity<>(tripDto, HttpStatus.OK);

	}

}
