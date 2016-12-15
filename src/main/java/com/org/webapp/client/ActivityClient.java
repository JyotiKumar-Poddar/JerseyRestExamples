package com.org.webapp.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.org.webapp.modal.Activity;
/**
 * Basic demo missing lots of conventions
 * @author jyotipoddar
 *
 */
public class ActivityClient {
	private Client client;
	private WebTarget target;

	public ActivityClient() {
		client = ClientBuilder.newClient();
		target = client.target("http://localhost:8080/webapi/webapi/");
	}

	public Activity get(String id) {

		// http://localhost:8080/webapi/webapi/activities/1234
		// Activity
		// activityResopne=target.path("activities/"+id).request().get(Activity.class);
		// for JSON response
		Response respone = target.path("activities/" + id)
				.request(MediaType.APPLICATION_JSON).get(Response.class);

		// for String as a return type : use when return type is not known or
		// problem in type conversion
		// String
		// activityResopne=target.path("activities/"+id).request(MediaType.APPLICATION_JSON).get(String.class);

		
		if (respone.getStatus() != 200) {
			System.out.println("==================================================="+respone.getStatus());
			throw new RuntimeException(respone.getStatus()
					+ " There was an error on server");
		}

		return respone.readEntity(Activity.class);
	}

	public List<Activity> get() {

		List<Activity> response = target.path("activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {}); // GenericType is used to convert collection of object in xml/json
		System.out.println(response);
		return response;
	}

	public Activity create(Activity activity) {
		Response respone = target.path("activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		if(respone.getStatus()!=200){
			throw new RuntimeException(respone.getStatus()+ " There was an error on server");
		}
		return respone.readEntity(Activity.class);
	}

	public Activity udpate(Activity activity) {
		Response respone = target.path("activities/"+activity.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		if(respone.getStatus()!=200){
			throw new RuntimeException(respone.getStatus()+ " There was an error on server");
		}
		//Activity  cctivity=respone.readEntity(Activity.class);
		return respone.readEntity(Activity.class);
	}


	
	public void delete(String activityId) {
		Response respone = target.path("activities/"+activityId).request(MediaType.APPLICATION_JSON).delete();
		if(respone.getStatus()!=200){
			throw new RuntimeException(respone.getStatus()+ " There was an error on server");
		}
		
	}

	public Response  getImg() {
		Response respone = target.path("activities/image").request(MediaType.TEXT_PLAIN).post(Entity.entity("abc", MediaType.APPLICATION_OCTET_STREAM));
		if(respone.getStatus()!=200){
			throw new RuntimeException(respone.getStatus()+ " There was an error on server");
		}
		return respone;
	}

}
