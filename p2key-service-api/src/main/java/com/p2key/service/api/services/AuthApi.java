package com.p2key.service.api.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.p2key.service.security.dto.AuthDTO;
import com.p2key.service.security.dto.TokenDTO;
import com.p2key.service.security.services.AuthManager;

@Path("auth")
public class AuthApi {

	@POST
	@Path("/token")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getToken(AuthDTO auth) {
		TokenDTO token = AuthManager.authenticate(auth);
		return Response.ok(token).status(200).build();
	}
}