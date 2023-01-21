package com.masai.services;

import java.util.List;

import com.masai.exception.ActivityException;
import com.masai.exception.LoginException;
import com.masai.model.Activity;

public interface ActivityService {

	public Activity insertActivity(Activity activity) throws ActivityException, LoginException;

	public Activity updateActivity(Activity activity) throws ActivityException, LoginException;

	public Activity deleteActivity(int activityid) throws ActivityException, LoginException;

	public List<Activity> viewActivityofCharges(float charges) throws ActivityException, LoginException;

	public int countActivityofCharges(float charges) throws ActivityException, LoginException;

}
