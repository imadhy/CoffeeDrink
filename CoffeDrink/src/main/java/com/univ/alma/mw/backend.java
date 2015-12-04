package com.univ.alma.mw;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class backend {

    private static final String authServer = "http://localhost:8080";
	private static final String REGEX_UUID = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[34][0-9a-fA-F]{3}-[8-9a-b][0-9a-fA-F]{3}-[0-9a-fA-F]{12}";

	@POST
	@Path("bonjour")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response bonjour() {

		int status = 200;
        String res = "[401] J'te connais pas va t'authentifier";

		return Response
			.status(status)
			.type(MediaType.TEXT_PLAIN)
			.entity(res)
			.build();
	}



    @POST
    @Path("callback")
    @Produces(MediaType.APPLICATION_JSON)
    public Response callback(String token) {

        int status = 200;
        String res = null;
        if(token.matches(REGEX_UUID)) {

        } else {

        }
        return Response
                .status(status)
                .type(MediaType.TEXT_PLAIN)
                .entity(res)
                .build();
    }

}
