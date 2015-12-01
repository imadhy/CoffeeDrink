package com.univ.alma.mw;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.alma.middleware.bearbouncer.Identity;
import org.alma.middleware.bearbouncer.Storage;

import com.google.gson.Gson;

public class backend {
	
	@POST
	@Path("bonjour")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response bonjour(String token) {
		Storage db = new Storage();
		
		int status = 200;
		String res = null;
		if(imei.matches(REGEX_IMEI)) {
			Identity identity = db.getIdentity(imei);
			if(identity != null) {
				status = HttpServletResponse.SC_OK;
				res = UUID.randomUUID().toString();
				db.putToken(res,imei);
			} else {
				status = HttpServletResponse.SC_NOT_FOUND;
				res = "No identity corresponds to IMEI '"+imei+"'";
			}
		} else {
			status = HttpServletResponse.SC_BAD_REQUEST;
			res = "Content is not a well formed IMEI.";
		}
		db.close();
		return Response
			.status(status)
			.type(MediaType.TEXT_PLAIN)
			.entity(res)
			.build();
	}

}
