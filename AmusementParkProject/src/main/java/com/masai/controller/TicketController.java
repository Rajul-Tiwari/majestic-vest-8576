package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ActivityException;
import com.masai.exception.TicketException;
import com.masai.model.Ticket;
import com.masai.services.TicketService;

@RestController
public class TicketController {
	
	@Autowired
	private TicketService tService;
	
	
	@PostMapping("/ticketBooking/{activity_id}/{cid}")
	public ResponseEntity<Ticket> bookticket(@RequestBody Ticket tkt,@PathVariable Integer activity_id,@PathVariable Integer cid) throws TicketException, ActivityException {

		Ticket t = tService.ticketBooking(tkt, activity_id, cid);

		return new ResponseEntity<Ticket>(t, HttpStatus.CREATED);

	}
	
}
