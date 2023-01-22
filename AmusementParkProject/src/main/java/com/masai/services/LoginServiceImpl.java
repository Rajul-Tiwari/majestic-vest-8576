package com.masai.services;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Admin;
import com.masai.model.AdminLoginDTO;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.repository.AdminDao;
import com.masai.repository.AdminSessionDao;
import com.masai.repository.CustomerDao;
import com.masai.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CustomerDao cDao;
	
	@Autowired
	private AdminSessionDao aSessionDao;
	
	@Autowired
	private SessionDao sDao;
	
	public static Admin admin;
	
	public static Customer customer;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		Customer existingCustomer = cDao.findByEmail(dto.getEmail());

		if (existingCustomer == null) {
			throw new LoginException("Please Enter a valid email or password");
		}

		Optional<CurrentUserSession> validCustomerSessionOpt = sDao.findById(existingCustomer.getCustomerID());

		if (validCustomerSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}

		if (existingCustomer.getPassword().equals(dto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerID(), key,
					LocalDateTime.now());
			sDao.save(currentUserSession);
			
			customer = existingCustomer;
			
			return currentUserSession.toString();

		} else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");

		}

		sDao.delete(validCustomerSession);
		
		customer = null;
		
		return "Logged Out !";

	}

	@Override
	public String adminLogIntoAccount(AdminLoginDTO dto) throws LoginException {
		
		Admin existingAdmin = adminDao.findByEmail(dto.getEmail());

		if (existingAdmin == null) {
			throw new LoginException("Please Enter a valid email or password");
		}

		Optional<CurrentAdminSession> validAdminSessionOpt = aSessionDao.findById(existingAdmin.getAdminID());

		if (validAdminSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}

		if (existingAdmin.getPassword().equals(dto.getPassword())) {
			String key = RandomString.make(6);
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminID(), key,
					LocalDateTime.now());
			aSessionDao.save(currentAdminSession);
			
			admin = existingAdmin;
			
			return currentAdminSession.toString();

		} else
			throw new LoginException("Please Enter a valid password");

	}

	@Override
	public String adminLogOutFromAccount(String key) throws LoginException {
		
		CurrentAdminSession validAdminSession = aSessionDao.findByUuid(key);

		if (validAdminSession == null) {
			
			throw new LoginException("User Not Logged In with this email");

		}

		aSessionDao.delete(validAdminSession);
		
		admin = null;
		
		return "Logged Out !";
	}

}
