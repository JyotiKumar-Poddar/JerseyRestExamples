package com.org.webapp.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.org.webapp.modal.Activity;

public class ActivityClientTest {

	
	@Test
	public void testDelete(){
		
		ActivityClient client = new ActivityClient();
		client.delete("1234");

	}
	
	@Test
	public void testPut() {
		Activity activity = new Activity();
		activity.setDescription("Yoga");
		activity.setDuration(12);
		activity.setId("3456");
		ActivityClient client = new ActivityClient();
		activity = client.udpate(activity);

	}

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1234");
		System.out.println(activity);
		assertNotNull(activity);
	}

	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		assertNotNull(activities);
	}

	@Test(expected = RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		client.get("124");
	}

	@Test(expected = RuntimeException.class)
	public void testGetWithNotFound() {
		ActivityClient client = new ActivityClient();
		client.get("12345");
	}

	@Test
	public void testCreate() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Hourse ridign");
		activity.setDuration(12);

		activity = client.create(activity);
		assertNotNull(activity);
	}
	@Test
	public void testActivityImage(){
		ActivityClient client= new  ActivityClient();
		assertNotNull(client.getImg());
		
	}
}
