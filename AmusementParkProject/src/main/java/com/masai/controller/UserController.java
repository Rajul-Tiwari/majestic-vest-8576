package com.masai.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.services.UserService;

import java.util.List;


//import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/customer")
public class UserController {
	

	@Autowired
	private UserService cService;
	
	
    static boolean isLogin = false;


	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerException {

		Customer c = cService.regCustomer(customer);

		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);

	}
    
    @PutMapping("/updateCustomers")
	public  ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,@RequestParam(required = false) String key ) throws CustomerException {
		
		if(isLogin) {
		Customer updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
		
		}else {
			
	    return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<String>deleteCustomer(@PathVariable ("customerId") Integer customerId)throws CustomerException{
		return new ResponseEntity(cService.deleteCustomer(customerId),HttpStatus.OK);
	}
@GetMapping("/allCustomer")
	public ResponseEntity<Object>getAllCustomer()throws CustomerException{
		if (isLogin){
			List<Customer> customerList=cService.getAllCustomer();
			return new ResponseEntity<>(customerList,HttpStatus.OK);
		}else{
			return new ResponseEntity<>("Please, Login first!",HttpStatus.OK);
		}
	}
	@GetMapping("/{customerId}")
	public ResponseEntity<Object>viewCustomerById(@PathVariable ("customerId") Integer customerId)throws CustomerException{
		return new ResponseEntity<>(cService.viewCustomer(customerId),HttpStatus.OK);
	}
}
