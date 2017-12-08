package org.learning.messenger.resources;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.learning.messenger.model.Message;
import org.learning.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService service=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getAllMessage() {
		return service.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return service.getMessage(messageId);
	}
}
