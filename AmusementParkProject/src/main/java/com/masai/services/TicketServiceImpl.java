package com.masai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ActivityException;
import com.masai.exception.TicketException;
import com.masai.model.Activity;
import com.masai.model.Customer;
import com.masai.model.Ticket;
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
	public Ticket ticketBooking(Ticket ticket) throws ActivityException, TicketException {
		// TODO Auto-generated method stub
		
		 Optional<Activity> pack = aDao.findById(ticket.getActivityid());
		 
		 Optional<Customer> c= cDao.findById(1);
		 Customer ctr= c.get();
		 
		
		
		 if(pack.isPresent()) {
			 
			   if(ticket.getAmount().equals(pack.get().getCharge())) {
				 
				   ticket.setCustomer(ctr);
				   
				   Ticket tkt= tDao.save(ticket);
				 
				 return tkt;
				 }
			   else {
				   
				   throw new TicketException("Amount should be equal to activity amount");
			   }

       }else{
			 
			      
				 
		   throw new ActivityException("please enter valid activity ID");
			 
			 
		 }
		
		
		 
	}
}
