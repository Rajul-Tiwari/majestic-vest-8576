package com.masai.services;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;




public interface UserService {
	
	
	public Customer regCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;
	
	
	
	
	
	
}
