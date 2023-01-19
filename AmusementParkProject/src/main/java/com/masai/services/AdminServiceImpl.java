package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.ActivityException;
import com.masai.exception.AdminException;
import com.masai.model.Activity;
import com.masai.model.Admin;
import com.masai.repository.AdminRepo;

public class AdminServiceImpl implements AdminService{
           @Autowired
	private AdminRepo adminRepo;
	
	
	@Override
	public Admin insertAdmin(Admin admin) {
		   
		   Admin adm= adminRepo.save(admin);
		
		      return adm;
		
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		             
		
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivities(Integer cutomerId) throws ActivityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getAllActivities() throws ActivityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getActivitiesDatewise(LocalDateTime date) throws ActivityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activity> getActivitiesForDays(Integer customerId, LocalDateTime fromdate, LocalDateTime toDate)
			throws ActivityException {
		// TODO Auto-generated method stub
		return null;
	}

}
