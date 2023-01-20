package com.masai.services;

import java.util.List;

import com.masai.exception.ActivityException;
import com.masai.model.Activity;

public interface ActivityService {
	
	public Activity insertActivity(Activity activity) throws ActivityException;
	public Activity updateActivity(Activity activity) throws ActivityException;
	public Activity deleteActivity(int activityid) throws ActivityException;
	public List<Activity> viewActivityofCharges(float charges) throws ActivityException;
	public int countActivityofCharges(float charges) throws ActivityException;

}
