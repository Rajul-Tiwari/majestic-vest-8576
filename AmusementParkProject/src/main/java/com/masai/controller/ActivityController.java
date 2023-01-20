package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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



@PutMapping("/updateActivity")
public ResponseEntity<Activity> updateActivity(@RequestBody  Activity activity) throws ActivityException{
	
	Activity a= aService.updateActivity(activity);
	
	return new ResponseEntity<Activity>(a, HttpStatus.OK);
	
	
}



@DeleteMapping("/deleteActivity")
public ResponseEntity<Activity> deleteActivity(int activityid) throws ActivityException{
	
	Activity a= aService.deleteActivity(activityid);
	
	return new ResponseEntity<Activity>(a, HttpStatus.OK);
	
	
}


@GetMapping("/viewActivityofCharges")
public ResponseEntity<List<Activity>>viewActivityofCharges(float charges) throws ActivityException{
	
	List<Activity> aList= aService.viewActivityofCharges(charges);
	
	return new ResponseEntity<List<Activity>>(aList, HttpStatus.OK);
	
	
}


 

   @GetMapping("/countctivityOfCharges")
   public ResponseEntity<Integer>  countActivityofCharges(float charges) throws ActivityException{
   	
   	int aCount= aService.countActivityofCharges(charges);
   	
   	return new ResponseEntity<Integer>(aCount, HttpStatus.OK);
   	
   	
   }







	

}
