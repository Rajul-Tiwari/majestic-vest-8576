package com.masai.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.services.LoginService;
import com.masai.services.UserService;





@RestController
@RequestMapping("/login")
public class LoginController {

  
	 @Autowired
	    private UserService cService;
   
    
    @Autowired
	private LoginService customerLogin;
    


    
	@PostMapping("/customerlogin")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
	
			String result = customerLogin.logIntoAccount(dto);
			if(result != null) {
	    		UserController.isLogin = true;
	    	}

			return new ResponseEntity<String>(result,HttpStatus.OK );	
	
	}
	
	@PatchMapping("/customerlogout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		String result = customerLogin.logOutFromAccount(key);
		if(result != null) {
    		UserController.isLogin = false;
    	}
		return result;
		
	}
	

}
