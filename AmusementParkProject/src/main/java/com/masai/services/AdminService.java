package com.masai.services;

import java.time.LocalDateTime;
import java.util.List;

import com.masai.exception.ActivityException;
import com.masai.exception.AdminException;
import com.masai.exception.LoginException;
import com.masai.model.Activity;
import com.masai.model.Admin;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin);

	public Admin updateAdmin(Admin admin) throws AdminException, LoginException;

	public Admin deleteAdmin(Integer adminId) throws AdminException;

	public List<Activity> getAllActivities(Integer cutomerId) throws ActivityException;

	public List<Activity> getAllActivities() throws ActivityException;

	public List<Activity> getActivitiesDatewise(LocalDateTime date) throws ActivityException;

	public List<Activity> getActivitiesForDays(Integer customerId, LocalDateTime fromdate, LocalDateTime toDate)
			throws ActivityException;

}
