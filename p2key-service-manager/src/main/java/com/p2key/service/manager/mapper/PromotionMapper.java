package com.p2key.service.manager.mapper;

import com.p2key.service.container.model.Promotion;
import com.p2key.service.manager.dto.PromotionDTO;

public class PromotionMapper {
	public static PromotionDTO mapToDto(Promotion model) {
		PromotionDTO dto = null;
		if(model != null) {
			dto = new PromotionDTO();
			dto.setId(model.getId());
			dto.setEndpoint(model.getEndpoint());
			dto.setOperation(model.getOperation());
			dto.setTimeout(model.getTimeout());
		}
		return dto;
	}
	
	public static Promotion mapToModel(PromotionDTO dto) {
		Promotion model = null;
		if(dto != null) {
			model =new Promotion();
			model.setId(dto.getId());
			model.setEndpoint(dto.getEndpoint());
			model.setEnvironment(dto.getEnvironment());
			model.setTimeout(dto.getTimeout());
		}
		return model;
	}
}
