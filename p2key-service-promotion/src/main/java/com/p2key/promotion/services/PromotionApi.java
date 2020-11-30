package com.p2key.promotion.services;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.p2key.service.manager.dto.MessageDTO;
import com.p2key.service.manager.services.PromotionManager;

@Path("promote")
public class PromotionApi {
	@POST
	@Path("/{serviceName}/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response promoteService(@PathParam("serviceName") String serviceName) {
		PromotionManager promotionManager = new PromotionManager();
		MessageDTO message = promotionManager.insertService(serviceName);
		return Response.ok(message).status(200).build();
	}
}