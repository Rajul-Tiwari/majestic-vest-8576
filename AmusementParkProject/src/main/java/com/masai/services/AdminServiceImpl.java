package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.ActivityException;
import com.masai.exception.AdminException;
import com.masai.model.Activity;
import com.masai.model.Admin;
import com.masai.repository.ActivityRepo;
import com.masai.repository.AdminRepo;

public class AdminServiceImpl implements AdminService{
           @Autowired
	private AdminRepo adminRepo;
	@Autowired
	private ActivityRepo activityRepo;
	
	@Override
	public Admin insertAdmin(Admin admin) {
		   
		   Admin adm= adminRepo.save(admin);
		
		      return adm;
		
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		                Optional<Admin> opt= adminRepo.findById(admin.getAdminID());
		                
		                if(opt.isPresent()) {
		                	       Admin updateAdmin=   adminRepo.save(admin);
		                	       return updateAdmin;
		                } else {
		                	throw new AdminException("Admin does not exits");
		                }
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		              Optional<Admin> opt= adminRepo.findById(adminId);
		              
		              if(opt.isPresent()) {
		            	         adminRepo.delete(opt.get());
		            	         return opt.get();
		              } else {
		            	  throw new AdminException("Admin does not found with adminId:"+adminId);
		              }
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
