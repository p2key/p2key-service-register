package com.p2key.service.manager.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.p2key.service.container.model.Promotion;
import com.p2key.service.container.operations.PromotionOperation;
import com.p2key.service.manager.dto.MessageDTO;
import com.p2key.service.manager.dto.ServiceDTO;
import com.p2key.service.manager.enums.PromotionType;
import com.p2key.service.manager.enums.Result;

public class PromotionManager {
	
	public MessageDTO promotionService(String serviceName, String auth, PromotionType promotionType) {
		MessageDTO message = new MessageDTO();

		ServiceManager serviceManager = new ServiceManager();
		ServiceDTO service = serviceManager.getService(serviceName);

		Promotion promotion = PromotionOperation.getPromotion(promotionType.toString());
		String promotionEndpoint = promotion.getEndpoint();
		if(PromotionType.UPDATE.equals(promotionType) || PromotionType.DELETE.equals(promotionType)) {
			promotionEndpoint = promotion.getEndpoint().replaceAll("\\{serviceName\\}", service.getName());
			
		}

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(promotionEndpoint);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		invocationBuilder.header("Authorization", auth);
		Response response = invocationBuilder.post(Entity.entity(service, MediaType.APPLICATION_JSON));
		
		if (response.getStatus() == 200) {
			message.setResult(Result.SUCCESS);
			message.setMessage("Service promotion is success.");
		} else if (response.getStatus() == 401) {
			message.setResult(Result.FAIL);
			message.setMessage("Authorization is failed.");
		}else {
			message = response.readEntity(MessageDTO.class);
		}
		return message;
	}

}
