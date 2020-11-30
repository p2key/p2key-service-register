package com.p2key.service.api.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.p2key.service.manager.services.ManagerFactory;
import com.p2key.service.manager.services.OwnerManager;

@Path("owner")
public class OwnerApi {
	private final OwnerManager ownerManager = ManagerFactory.getOwnerManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("all")
    public Response getAllOwners() {
        return Response.ok(ownerManager.getAllOwner(), MediaType.APPLICATION_JSON).status(200).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{ownerId}")
    public Response getService(@PathParam("ownerId") long ownerId) {
        return Response.ok(ownerManager.getOwner(ownerId), MediaType.APPLICATION_JSON).status(200).build();
    }
}