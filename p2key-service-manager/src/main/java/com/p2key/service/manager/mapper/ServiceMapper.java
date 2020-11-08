package com.p2key.service.manager.mapper;

import java.util.ArrayList;
import java.util.List;

import com.p2key.service.container.model.Service;
import com.p2key.service.manager.dto.ServiceDTO;

public class ServiceMapper {
	public static ServiceDTO mapToDto(Service model) {
		ServiceDTO dto = null;
		if(model != null) {
			dto = new ServiceDTO();
			dto.setId(model.getId());
			dto.setOwnerId(model.getOwnerId());
			dto.setName(model.getName());
			dto.setContent(model.getContent());
			dto.setType(model.getType());
			dto.setVersion(model.getVersion());
			dto.setUpdateDate(model.getUpdateDate());
			dto.setUpdatedBy(model.getUpdatedBy());
			dto.setCreateDate(model.getCreateDate());
			dto.setCreatedBy(model.getCreatedBy());
			dto.setActive(model.getIsActive());
		}
		return dto;
	}
	
	public static List<ServiceDTO> mapToDtos(List<Service> models) {
		List<ServiceDTO> dtos = new ArrayList<ServiceDTO>();
		if(models != null) {
			for(Service model : models) {
				ServiceDTO dto = new ServiceDTO();
				dto.setId(model.getId());
				dto.setOwnerId(model.getOwnerId());
				dto.setName(model.getName());
				dto.setContent(model.getContent());
				dto.setType(model.getType());
				dto.setVersion(model.getVersion());
				dto.setUpdateDate(model.getUpdateDate());
				dto.setUpdatedBy(model.getUpdatedBy());
				dto.setCreateDate(model.getCreateDate());
				dto.setCreatedBy(model.getCreatedBy());
				dto.setActive(model.getIsActive());
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	public static Service mapToModel(ServiceDTO dto) {
		Service model = null;
		if(dto != null) {
			model =new Service();
			model.setId(dto.getId());
			model.setOwnerId(dto.getOwnerId());
			model.setType(dto.getType());
			model.setName(dto.getName());
			model.setVersion(dto.getVersion());
			model.setContent(dto.getContent());
			model.setUpdateDate(dto.getUpdateDate());
			model.setUpdatedBy(dto.getUpdatedBy());
			model.setCreateDate(dto.getCreateDate());
			model.setCreatedBy(dto.getCreatedBy());
			model.setIsActive(dto.isActive());
		}
		return model;
	}
	
	public static List<Service> mapToModels(List<ServiceDTO> dtos) {
		List<Service> models = new ArrayList<Service>();
		if(dtos != null) {
			for(ServiceDTO dto : dtos) {
				Service model = new Service();
				model.setId(dto.getId());
				model.setOwnerId(dto.getOwnerId());
				model.setType(dto.getType());
				model.setName(dto.getName());
				model.setVersion(dto.getVersion());
				model.setContent(dto.getContent());
				model.setUpdateDate(dto.getUpdateDate());
				model.setUpdatedBy(dto.getUpdatedBy());
				model.setCreateDate(dto.getCreateDate());
				model.setCreatedBy(dto.getCreatedBy());
				model.setIsActive(dto.isActive());
				models.add(model);
			}
		}
		return models;
	}
}
