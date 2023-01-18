package com.masai.model;

import java.time.LocalDateTime;

public class Ticket {
	
	private Integer ticketId;
	
	private Customer customer;
	
	private Activity activity;
	
	private LocalDateTime dateTime;

	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(Integer ticketId, Customer customer, Activity activity, LocalDateTime dateTime) {
		super();
		this.ticketId = ticketId;
		this.customer = customer;
		this.activity = activity;
		this.dateTime = dateTime;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
