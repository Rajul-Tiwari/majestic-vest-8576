package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ActivityException;
import com.masai.model.Activity;
import com.masai.repository.ActivityDao;


@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	ActivityDao aDao;

	@Override
	public Activity insertActivity(Activity activity) throws ActivityException {
		
		Activity a= aDao.save(activity);
		
		return a;
	}

	@Override
	public Activity updateActivity(Activity activity) throws ActivityException {
		// TODO Auto-generated method stub
		
		Optional<Activity> a= aDao.findById(activity.getActivityId());
		
		if(a.isPresent()) {
			
		Activity act=	a.get();
		act.setDescription(activity.getDescription());
		act.setCharge(activity.getCharge());
		
		Activity updated =aDao.save(act);
		
		
		return updated;
			
		}else {
			
			throw new ActivityException("No activity with this id");
			
		}
		
		
	}

	@Override
	public Activity deleteActivity(int activityid) throws ActivityException {
		// TODO Auto-generated method stub
		Optional<Activity> a= aDao.findById(activityid);
		
		if(a.isPresent()) {
			Activity act= a.get();
			
			aDao.delete(act);
			
			return act;
		}else {
			
			throw new ActivityException("No activity with this id");
		}
		
		
	}

	@Override
	public List<Activity> viewActivityofCharges(float charges) throws ActivityException {
		// TODO Auto-generated method stub
		
		List<Activity> act = aDao.findByCharge(charges);
		
		if(act.isEmpty()) {
			
			throw new ActivityException("No activity List Database");
		}else {
			
			return act;
		}
		
		
		
	}

	@Override
	public int countActivityofCharges(float charges) throws ActivityException {
		// TODO Auto-generated method stub
		
		List<Activity> act = aDao.findByCharge(charges);
		
     if(act.isEmpty()) {
			
			throw new ActivityException("No activity List Database");
		}else {
			
			return act.size();
		}
		
	
	}

}
