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
import com.p2key.service.security.dto.AuthDTO;
import com.p2key.service.security.dto.TokenDTO;
import com.p2key.service.security.services.AuthManager;

public class PromotionManager {
	private final AuthManager authManager = new AuthManager();
	
	public MessageDTO insertService(String serviceName) {
		MessageDTO message = new MessageDTO();

		ServiceManager serviceManager = new ServiceManager();
		ServiceDTO service = serviceManager.getService(serviceName);

		Promotion promotion = PromotionOperation.getPromotion(PromotionType.INSERT.toString());

		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(promotion.getEndpoint());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//		AuthDTO auth = new AuthDTO();
//		auth.setUserName("admin");
//		auth.setPassword("pass");
//		TokenDTO token = authManager.authenticate(auth);
//		invocationBuilder.header("Authorization", "Bearer " + token.getToken());
		//TODO: send incoming token on http header
		Response response = invocationBuilder.post(Entity.entity(service, MediaType.APPLICATION_JSON));
		if (response.getStatus() == 200) {
			message.setResult(Result.SUCCESS);
			message.setMessage("Service is deployed to upper environment.");
		} else {
			message.setResult(Result.FAIL);
			message.setMessage("Service deployment is failed.");
		}
		return message;
	}

}
