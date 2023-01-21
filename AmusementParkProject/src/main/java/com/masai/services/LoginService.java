package com.masai.services;

import javax.security.auth.login.LoginException;

import com.masai.model.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO dto) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;
	
	public String adminLogIntoAccount(LoginDTO dto) throws LoginException;

	public String adminLogOutFromAccount(String key) throws LoginException;

}
