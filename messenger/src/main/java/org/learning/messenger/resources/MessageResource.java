package org.learning.messenger.resources;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.learning.messenger.model.Message;
import org.learning.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService service=new MessageService();
	
//	@GET
//	public List<Message> getAllMessage(@QueryParam("year") int year,
//									   @QueryParam("start") int start,
//									   @QueryParam("size") int size) {
	@GET
	public List<Message> getAllMessage(@BeanParam MessageBeanParam param) {
		
		if(param.getYear() > 0) {
			return service.getMessageByYear(param.getYear());
		}
		else if(param.getStart() > 0 && param.getSize() > 0) {
			return service.getMessageByPage(param.getStart(), param.getSize());
		}
		return service.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {
		return service.getMessage(messageId);
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Message addMessage(Message message) {
//		return service.addMessage(message);
//	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response addMessage(Message message) {
//		return Response.status(Status.CREATED)
//			.entity(service.addMessage(message)).build();
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uri) throws URISyntaxException {
		message=service.addMessage(message);
		String id=String.valueOf(message.getId());
		URI newUri=uri.getAbsolutePathBuilder().path(id).build();
		return Response.created(newUri)
			.entity(message).build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id,Message message) {
		message.setId(id);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		service.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
	
}
