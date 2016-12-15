package com.org.webapp.resource;

import java.io.File;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.org.webapp.modal.Activity;
import com.org.webapp.repository.ActivityRepository;
import com.org.webapp.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {

	private ActivityRepository activityRepository = new ActivityRepositoryStub();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Activity> getAllActivity() {
		return activityRepository.getAllActivities();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("StringActivity")
	public String getAllActivityString() {
		return activityRepository.getAllActivities().toString();
	}

	// http://localhost:8080/webapi/webapi/activities/1234
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{activityId}")
	public Response getActivity(@PathParam("activityId") String activityId) {
		if (activityId == null || activityId.length() < 4) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		Activity activity = activityRepository.findActivity(activityId);
		if (activity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok().entity(activity).build();
	}

	// request with x-www.form-urlencoded
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Activity createActivityParams(
			MultivaluedMap<String, String> formParams) {
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));

		Activity activity = new Activity();
		activity.setDescription(formParams.getFirst("description"));
		activity.setDuration(Integer.valueOf(formParams.getFirst("duration")));

		activityRepository.creatActivity(activity);

		return activity;
	}

	// request with raw JSON content type
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Activity createActivity(Activity activity) {
		System.out.println(activity);
		activityRepository.creatActivity(activity);
		return activity;
	}

	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response update(Activity activity) {
		System.out.println(activity.getId());

		activity = activityRepository.update(activity);
		return Response.ok().entity(activity).build();

	}

	@DELETE
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response delete(String activityId) {

		activityRepository.delete(activityId);
		return Response.ok().build();

	}

	@GET
	@Path("image")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getImage() {
		System.out.println("Hii....");

		File file = new File("E:\\RestFull-Workspace\\webapi\\src\\main\\resources\\yuna.jpg");

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.png");
		return response.build();

	}

}
