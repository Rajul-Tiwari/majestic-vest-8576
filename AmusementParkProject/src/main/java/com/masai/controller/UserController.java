package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.masai.exception.ActivityException;
import com.masai.exception.CustomerException;
import com.masai.model.Activity;
import com.masai.model.Customer;
import com.masai.services.ActivityService;
import com.masai.services.UserService;

import java.util.List;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private UserService cService;

	@Autowired
	private ActivityService aService;

	public static boolean isLogin = false;

	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws CustomerException {

		Customer c = cService.regCustomer(customer);

		return new ResponseEntity<Customer>(c, HttpStatus.CREATED);

	}

	@PutMapping("/updateCustomers")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer,
			@RequestParam(required = false) String key) throws CustomerException {

		if (isLogin) {
			Customer updatedCustomer = cService.updateCustomer(customer, key);

			return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

		} else {

			return new ResponseEntity<>("Please, Login first!", HttpStatus.OK);
		}
	}

	@GetMapping("/getAllActivity")
	public ResponseEntity<List<Activity>> getAllactivity() throws ActivityException {

		List<Activity> actvityList = cService.getAllActivity();

		return new ResponseEntity<List<Activity>>(actvityList, HttpStatus.OK);

	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Object> viewCustomerById(@PathVariable("customerId") Integer customerId)
			throws CustomerException {
		return new ResponseEntity<>(cService.viewCustomer(customerId), HttpStatus.OK);
	}
}
