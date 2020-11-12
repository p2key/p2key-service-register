package com.p2key.service.api.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.p2key.service.api.error.Error;
import com.p2key.service.security.dto.TokenDTO;
import com.p2key.service.security.services.AuthManager;


@Provider
@JwtToken
@Priority(Priorities.AUTHENTICATION)
public class JwtTokenFilter implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		Error error = new Error(401, "Token is required to call the operation.");
		Response resp = Response.status(Response.Status.UNAUTHORIZED).entity(error).build();
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			requestContext.abortWith(resp);
		} else {
			try {
				TokenDTO token = new TokenDTO(authorizationHeader.substring("Bearer".length()).trim());
				AuthManager.validate(token);
			} catch (Exception e) {
				requestContext.abortWith(resp);
			}

		}
	}
}
