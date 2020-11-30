package com.p2key.service.api.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.p2key.service.api.filter.JwtToken;
import com.p2key.service.manager.dto.ServiceDTO;
import com.p2key.service.manager.mapper.MessageMapper;
import com.p2key.service.manager.services.ManagerFactory;
import com.p2key.service.manager.services.ServiceManager;

@Path("service")
public class ServiceApi {
	private final ServiceManager serviceManager = ManagerFactory.getServiceManager();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getAllServices() {
		return Response.ok(serviceManager.getAllServices(), MediaType.APPLICATION_JSON).status(200).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("all/actives")
	public Response getAllActiveServices() {
		return Response.ok(serviceManager.getAllActiveServices(), MediaType.APPLICATION_JSON).status(200).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("all/deactives")
	public Response getAllDeactiveServices() {
		return Response.ok(serviceManager.getAllDeactiveServices(), MediaType.APPLICATION_JSON).status(200).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{serviceName}")
	public Response getService(@PathParam("serviceName") String serviceName) {
		return Response.ok(serviceManager.getService(serviceName), MediaType.APPLICATION_JSON).status(200).build();
	}

	@JwtToken
	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertService(ServiceDTO service) {
		boolean result = serviceManager.insertService(service);
		if (result)
			return Response.ok(result).status(200).build();
		return Response.ok(MessageMapper.getFailMessage()).status(200).build();
	}
	
	@JwtToken
	@POST
	@Path("/{serviceName}/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateService(@PathParam("serviceName") String serviceName, ServiceDTO service) {
		service.setName(serviceName);
		boolean result = serviceManager.updateService(service);
		if (result)
			return Response.ok(result).status(200).build();
		return Response.ok(MessageMapper.getFailMessage()).status(200).build();
	}
	
	@JwtToken
	@POST
	@Path("/{serviceName}/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteService(@PathParam("serviceName") String serviceName, ServiceDTO service) {
		service.setName(serviceName);
		boolean result = serviceManager.deleteService(service);
		if (result)
			return Response.ok(result).status(200).build();
		return Response.ok(MessageMapper.getFailMessage()).status(200).build();
	}
}