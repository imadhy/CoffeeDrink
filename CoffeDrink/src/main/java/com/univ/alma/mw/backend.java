package com.univ.alma.mw;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class backend {

	@GET
	@Path("bonjour")
    @Produces(MediaType.APPLICATION_JSON)
	public Response bonjour() {

		int status = 200;
        String res = "[401] J'te connais pas va t'authentifier";


		return Response
			.status(status)
			.type(MediaType.APPLICATION_JSON)
			.entity(res)
			.build();
	}

    @POST
    @Path("callback")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response callback(String token) {

        int status = 200;
        String res = null;
        if(token.matches()) {

        } else {

        }
        return Response
                .status(status)
                .type(MediaType.TEXT_PLAIN)
                .entity(res)
                .build();
    }
}
