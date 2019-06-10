package com.ayach.francestation.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenericExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		return Response.serverError().entity(exception.getMessage()).build();
	}


}
