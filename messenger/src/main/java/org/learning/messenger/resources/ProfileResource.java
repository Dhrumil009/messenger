package org.learning.messenger.resources;

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

import org.learning.messenger.model.Profile;
import org.learning.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_XML)
public class ProfileResource {
	
	ProfileService service=new ProfileService();
	
	@GET
	public List<Profile> getAllPrfile(){
		return service.getAllProfiles();
	}
	
	@GET
	@Path("/{name}")
	public Profile getPrfile(@PathParam("name") String name) {
		return service.getProfile(name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addPrfile(Profile profile) {
		return service.addProfile(profile);
	}
	
	@PUT
	@Path("/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updatePrfile(@PathParam("name") String  name,Profile profile) {
		profile.setProfileName(name);
		return service.updatePrifile(profile);
	}
	
	@DELETE
	@Path("/{name}")
	public void deleteProfile(@PathParam("name") String name) {
		service.removeMessage(name);
	}
	

}
