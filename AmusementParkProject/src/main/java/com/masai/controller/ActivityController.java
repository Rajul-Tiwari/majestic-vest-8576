package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ActivityException;

import com.masai.model.Activity;

import com.masai.services.ActivityService;
import com.masai.services.UserService;

@RestController
public class ActivityController {
	
@Autowired
ActivityService aService;


@Autowired
private UserService cService;


@PostMapping("/insertActivity")
public ResponseEntity<Activity> createCustomer(@RequestBody Activity act) throws  ActivityException {

	Activity a = aService.insertActivity(act);

	return new ResponseEntity<Activity>(a, HttpStatus.CREATED);

}



@GetMapping("/getAllActivity")
public ResponseEntity<List<Activity>> getAllactivity() throws ActivityException{
	
	List<Activity>actvityList=  cService.getAllActivity();
	
	return new ResponseEntity<List<Activity>>(actvityList,HttpStatus.OK);
	
	
}






	

}
