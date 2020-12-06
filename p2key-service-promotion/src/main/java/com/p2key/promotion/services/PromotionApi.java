package com.p2key.promotion.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.p2key.service.manager.dto.MessageDTO;
import com.p2key.service.manager.enums.PromotionType;
import com.p2key.service.manager.services.ManagerFactory;
import com.p2key.service.manager.services.PromotionManager;

@Path("promote")
public class PromotionApi {
	private final PromotionManager promotionManager = ManagerFactory.getPromotionManager();

	@POST
	@Path("/{serviceName}/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertService(@PathParam("serviceName") String serviceName,
			@HeaderParam("Authorization") String auth) {
		MessageDTO message = promotionManager.promotionService(serviceName, auth, PromotionType.INSERT);
		return Response.ok(message).status(200).build();
	}

	@POST
	@Path("/{serviceName}/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateService(@PathParam("serviceName") String serviceName,
			@HeaderParam("Authorization") String auth) {
		MessageDTO message = promotionManager.promotionService(serviceName, auth, PromotionType.UPDATE);
		return Response.ok(message).status(200).build();
	}

	@POST
	@Path("/{serviceName}/delete")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteService(@PathParam("serviceName") String serviceName,
			@HeaderParam("Authorization") String auth) {
		MessageDTO message = promotionManager.promotionService(serviceName, auth, PromotionType.DELETE);
		return Response.ok(message).status(200).build();
	}

}