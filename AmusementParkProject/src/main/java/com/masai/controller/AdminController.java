package com.masai.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ActivityException;
import com.masai.exception.AdminException;
import com.masai.model.Activity;
import com.masai.model.Admin;

import com.masai.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService aService;
	
	public static boolean isLogin = false;

	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) throws AdminException {

		Admin c = aService.insertAdmin(admin);

		return new ResponseEntity<Admin>(c, HttpStatus.CREATED);

	}

	@PutMapping("/updateadmins")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin) throws AdminException {

		Admin ad = aService.updateAdmin(admin);
		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteadmin/{id}")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable("id") Integer id) throws AdminException {

		Admin ad = aService.deleteAdmin(id);
		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAllactivitybycustomerid/{id}")
	public ResponseEntity<List<Activity>> getAllActivityByCustomerIdHandler(@PathVariable("id") Integer id)
			throws ActivityException {

		List<Activity> activities = aService.getAllActivities(id);
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getallactivity")
	public ResponseEntity<List<Activity>> getAllActivityHandler() throws ActivityException {

		List<Activity> activities = aService.getAllActivities();
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getactivitybydate/{date}")
	public ResponseEntity<List<Activity>> getAllActivityByDateHandler(@PathVariable("date") String date)
			throws ActivityException {

		String dateString = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatter);
		List<Activity> activities = aService.getActivitiesDatewise(parsedDate);

		return new ResponseEntity<List<Activity>>(activities, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getactivitybydateandcustomerid/{customerid}/{fromdate}/{todate}")
	public ResponseEntity<List<Activity>> getAllActivityByDateandcustomeridHandler(
			@PathVariable("customerid") Integer customerid, @PathVariable("fromdate") String fromdate,
			@PathVariable("todate") String todate) throws ActivityException {

		String dateString = fromdate;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatter);
		String dateString1 = todate;
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		LocalDateTime parsedDate1 = LocalDateTime.parse(dateString1, formatter1);
		List<Activity> activities = aService.getActivitiesForDays(customerid, parsedDate, parsedDate1);

		return new ResponseEntity<List<Activity>>(activities, HttpStatus.ACCEPTED);
	}

}