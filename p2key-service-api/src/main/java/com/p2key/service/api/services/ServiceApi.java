package com.p2key.service.api.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.p2key.service.manager.dto.ServiceDTO;
import com.p2key.service.manager.mapper.MessageMapper;
import com.p2key.service.manager.services.ServiceManager;

@Path("service")
public class ServiceApi {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getAllServices() {
		ServiceManager serviceManager = new ServiceManager();
		return Response.ok(serviceManager.getAllServices(), MediaType.APPLICATION_JSON).status(200).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("all/actives")
	public Response getAllActiveServices() {
		ServiceManager serviceManager = new ServiceManager();
		return Response.ok(serviceManager.getAllActiveServices(), MediaType.APPLICATION_JSON).status(200).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("all/deactives")
	public Response getAllDeactiveServices() {
		ServiceManager serviceManager = new ServiceManager();
		return Response.ok(serviceManager.getAllDeactiveServices(), MediaType.APPLICATION_JSON).status(200).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{serviceName}")
	public Response getService(@PathParam("serviceName") String serviceName) {
		ServiceManager serviceManager = new ServiceManager();
		return Response.ok(serviceManager.getService(serviceName), MediaType.APPLICATION_JSON).status(200).build();
	}

	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertService(ServiceDTO service) {
		ServiceManager serviceManager = new ServiceManager();
		boolean result = serviceManager.insertService(service);
		if (result)
			return Response.ok(result).status(200).build();
		return Response.ok(MessageMapper.getFailMessage()).status(200).build();
	}
	
	
	@POST
	@Path("/{serviceName}/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateService(@PathParam("serviceName") String serviceName, ServiceDTO service) {
		ServiceManager serviceManager = new ServiceManager();
		service.setName(serviceName);
		boolean result = serviceManager.updateService(service);
		if (result)
			return Response.ok(result).status(200).build();
		return Response.ok(MessageMapper.getFailMessage()).status(200).build();
	}
	
	@POST
	@Path("/{serviceName}/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteService(@PathParam("serviceName") String serviceName, ServiceDTO service) {
		ServiceManager serviceManager = new ServiceManager();
		service.setName(serviceName);
		boolean result = serviceManager.deleteService(service);
		if (result)
			return Response.ok(result).status(200).build();
		return Response.ok(MessageMapper.getFailMessage()).status(200).build();
	}
}