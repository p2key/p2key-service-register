package com.p2key.service.manager.services;

import java.util.Date;
import java.util.List;

import com.p2key.service.container.model.Service;
import com.p2key.service.container.operations.ServiceOperation;
import com.p2key.service.manager.dto.ServiceDTO;
import com.p2key.service.manager.mapper.ServiceMapper;

public class ServiceManager {
	
	public List<ServiceDTO> getAllServices() {
		List<Service> models = ServiceOperation.getAllServices();
		List<ServiceDTO> dtos = ServiceMapper.mapToDtos(models);
		return dtos;
	}
	
	public List<ServiceDTO> getAllActiveServices() {
		List<Service> models = ServiceOperation.getAllActiveServices();
		List<ServiceDTO> dtos = ServiceMapper.mapToDtos(models);
		return dtos;
	}
	
	public List<ServiceDTO> getAllDeactiveServices() {
		List<Service> models = ServiceOperation.getAllDeactiveServices();
		List<ServiceDTO> dtos = ServiceMapper.mapToDtos(models);
		return dtos;
	}

	public ServiceDTO getService(String serviceName) {
		Service model = ServiceOperation.getService(serviceName);
		return ServiceMapper.mapToDto(model);
	}
	
	public boolean insertService(ServiceDTO service) {
		service.setCreateDate(new Date());
		Service model = ServiceMapper.mapToModel(service);
		return ServiceOperation.insertService(model);
	}
	
	public boolean updateService(ServiceDTO service) {
		service.setUpdateDate(new Date());
		Service model = ServiceMapper.mapToModel(service);
		return ServiceOperation.updateService(model);
	}
	
	public boolean deleteService(ServiceDTO service) {
		Service model = ServiceMapper.mapToModel(service);
		return ServiceOperation.deleteService(model);
	}
}
