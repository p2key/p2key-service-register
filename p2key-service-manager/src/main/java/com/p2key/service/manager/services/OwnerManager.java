package com.p2key.service.manager.services;

import java.util.List;

import com.p2key.service.container.model.Owner;
import com.p2key.service.container.operations.OwnerOperation;
import com.p2key.service.manager.dto.OwnerDTO;
import com.p2key.service.manager.mapper.OwnerMapper;

public class OwnerManager {
	public List<OwnerDTO> getAllOwner() {
		List<Owner> models = OwnerOperation.getAllOwners();
		List<OwnerDTO> dtos = OwnerMapper.mapToDtos(models);
		return dtos;
	}

	public OwnerDTO getOwner(long ownerId) {
		Owner model = OwnerOperation.getOwner(ownerId);
		return OwnerMapper.mapToDto(model);
	}
}
