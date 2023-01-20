package com.masai.services;

import java.util.List;
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
	public Ticket ticketBooking(Ticket ticket,Integer activity_id,Integer cid) throws ActivityException, TicketException {
		// TODO Auto-generated method stub
		
 Optional<Activity> pack = aDao.findById(activity_id);
		 
		 Optional<Customer> c= cDao.findById(cid);
		 Customer ctr= c.get();
		 
		
		
		 if(pack.isPresent()) {
			 
			   if(ticket.getAmount().equals(pack.get().getCharge())) {
				 
				   ticket.setCustomer(ctr);
				   ticket.setActivity(pack.get());
				   
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

	@Override
	public Ticket updateTicketBooking(Ticket ticketBooking) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> viewAllTicketCustomer(Integer customerId) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}
}
