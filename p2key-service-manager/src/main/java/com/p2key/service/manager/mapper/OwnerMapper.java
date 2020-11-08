package com.p2key.service.manager.mapper;

import java.util.ArrayList;
import java.util.List;

import com.p2key.service.container.model.Owner;
import com.p2key.service.manager.dto.OwnerDTO;

public class OwnerMapper {
	public static OwnerDTO mapToDto(Owner model) {
		OwnerDTO dto = null;
		if(model != null) {
			dto = new OwnerDTO();
			dto.setId(model.getId());
			dto.setName(model.getName());
			dto.setUpdateDate(model.getUpdateDate());
			dto.setUpdatedBy(model.getUpdatedBy());
			dto.setCreateDate(model.getCreateDate());
			dto.setCreatedBy(model.getCreatedBy());
		}
		return dto;
	}
	
	public static List<OwnerDTO> mapToDtos(List<Owner> models) {
		List<OwnerDTO> dtos = new ArrayList<OwnerDTO>();
		if(models != null) {
			for(Owner model : models) {
				OwnerDTO dto = new OwnerDTO();
				dto.setId(model.getId());
				dto.setName(model.getName());
				dto.setUpdateDate(model.getUpdateDate());
				dto.setUpdatedBy(model.getUpdatedBy());
				dto.setCreateDate(model.getCreateDate());
				dto.setCreatedBy(model.getCreatedBy());
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	public static Owner mapToModel(OwnerDTO dto) {
		Owner model = null;
		if(dto != null) {
			model =new Owner();
			model.setId(dto.getId());
			model.setName(dto.getName());
			model.setUpdateDate(dto.getUpdateDate());
			model.setUpdatedBy(dto.getUpdatedBy());
			model.setCreateDate(dto.getCreateDate());
			model.setCreatedBy(dto.getCreatedBy());
		}
		return model;
	}
	
	public static List<Owner> mapToModels(List<OwnerDTO> dtos) {
		List<Owner> models = new ArrayList<Owner>();
		if(dtos != null) {
			for(OwnerDTO dto : dtos) {
				Owner model = new Owner();
				model.setId(dto.getId());
				model.setName(dto.getName());
				model.setUpdateDate(dto.getUpdateDate());
				model.setUpdatedBy(dto.getUpdatedBy());
				model.setCreateDate(dto.getCreateDate());
				model.setCreatedBy(dto.getCreatedBy());
				models.add(model);
			}
		}
		return models;
	}
}
