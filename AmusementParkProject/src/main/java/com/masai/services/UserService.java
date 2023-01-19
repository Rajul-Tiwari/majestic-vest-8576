package com.masai.services;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

import java.util.List;


public interface UserService {
	
	
	public Customer regCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;

	public String deleteCustomer(Integer customerId)throws CustomerException;

	public List<Customer> getAllCustomer() throws CustomerException;
	
	
	
	
	
	
}
