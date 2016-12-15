package com.org.webapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.org.webapp.modal.Activity;

public class ActivityRepositoryStub implements ActivityRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.webapp.repository.ActivityRepository#getAllActivities()
	 */
	@Override
	public List<Activity> getAllActivities() {

		List<Activity> activities = new ArrayList<Activity>();
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);

		activities.add(activity1);

		Activity activity2 = new Activity();
		activity2.setDescription("Cylcling");
		activity2.setDuration(150);

		activities.add(activity2);
		return activities;
	}

	@Override
	public void creatActivity(Activity activity) {
		// TODO code to insert into db

	}

	@Override
	public Activity update(Activity activity) {
		// TODO Auto-generated method stub
		// do activity related with db operations including update and create is
		// record does not exists
		return activity;
	}

	@Override
	public Activity findActivity(String activityId) {

		if ("12345".equalsIgnoreCase(activityId)) {
			return null;
		}
		Activity activity1 = new Activity();
		activity1.setDescription("Swming");
		activity1.setDuration(55);
		activity1.setId(activityId);
		return activity1;

	}
	@Override
	public void delete(String activityId) {
		// TODO Auto-generated method stub
		
	}

}
