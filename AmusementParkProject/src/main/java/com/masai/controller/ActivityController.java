package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ActivityException;

import com.masai.model.Activity;

import com.masai.services.ActivityService;

@RestController
public class ActivityController {
	
@Autowired
ActivityService aService;


@PostMapping("/insertActivity")
public ResponseEntity<Activity> createCustomer(@RequestBody Activity act) throws  ActivityException {

	Activity a = aService.insertActivity(act);

	return new ResponseEntity<Activity>(a, HttpStatus.CREATED);

}


	

}
