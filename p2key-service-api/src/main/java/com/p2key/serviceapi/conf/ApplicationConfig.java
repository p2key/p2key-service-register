package com.p2key.serviceapi.conf;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.p2key.service.api.filter.JwtTokenFilter;
import com.p2key.service.api.services.AuthApi;
import com.p2key.service.api.services.OwnerApi;
import com.p2key.service.api.services.ServiceApi;

@ApplicationPath("rest")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		packages("com.p2key.service.api.services", "com.p2key.service.api.filter");
		register(JwtTokenFilter.class);
		register(AuthApi.class);
		register(ServiceApi.class);
		register(OwnerApi.class);
	}
}