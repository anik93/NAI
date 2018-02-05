package com.simpleproject.service;

import com.simpleproject.domain.BasicEntity;

public interface DTOService {

	public <K extends BasicEntity, T> T generateDTOResponse(K object, Class<T> clazz);

}
