package com.org.webapp.repository;

import java.util.List;

import com.org.webapp.modal.Activity;

public interface ActivityRepository {

	List<Activity> getAllActivities();

	void creatActivity(Activity activity);

	Activity findActivity(String activityId);

	Activity update(Activity activity);

	void delete(String activityId);

}