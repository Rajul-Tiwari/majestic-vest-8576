package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

import javax.swing.*;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private CustomerDao cDao;


	
	@Autowired
	private SessionDao sDao;
	
	@Override
	public Customer regCustomer(Customer customer) throws CustomerException {
		Customer exsistingcustomer = cDao.findByEmail(customer.getEmail());

		if (exsistingcustomer != null) {
			throw new CustomerException("Customer with this email already registered !");
		}

		return cDao.save(customer);
	}

	
	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}
		
		
	
		
		if(customer.getCustomerID()== loggedInUser.getUserId()) {
			//If LoggedInUser id is same as the id of supplied Customer which we want to update
			return cDao.save(customer);
		}
		else
			throw new CustomerException("Invalid Customer Details, please login first");
	}

	@Override
	public String deleteCustomer(Integer customerId) throws CustomerException {
		CurrentUserSession userSession=sDao.findById(customerId).orElseThrow(()->new CustomerException("Customer not fount with this Id"));
			Customer customer= cDao.findById(customerId).orElseThrow(()->new CustomerException("Cucstomer not found with thiss id"));
		if(userSession!=null){
			sDao.delete(userSession);
			cDao.delete(customer);

			return "deleted";
		}
		throw new CustomerException("Not Deleted");

	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException {
		List<Customer>customer=cDao.findAll();

		if(customer.isEmpty()){
			throw new CustomerException("Customer not exist");
		}
		else{
			return customer;
		}

	}


}
