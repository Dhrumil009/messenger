package org.learning.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.learning.messenger.model.ErrorModel;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		return Response.status(Status.NOT_FOUND).
				entity(new ErrorModel(404,"Data Not Found")).build();
	}
	
	

}
