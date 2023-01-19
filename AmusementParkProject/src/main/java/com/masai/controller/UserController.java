package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.services.UserService;


//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/customer")
public class UserController {
	

	@Autowired
	private UserService cService;
	
	
    static boolean isLogin = false;
    
    @PutMapping("/updateCustomers")
	public  ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		if(isLogin) {
		Customer updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
		
		}else {
			
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}

	
	

}
