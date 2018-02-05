package com.simpleproject.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleproject.domain.BasicEntity;
import com.simpleproject.service.DTOService;

@Service
public class DTOServiceImpl implements DTOService {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public <K extends BasicEntity, T> T generateDTOResponse(K object, Class<T> clazz) {
		return modelMapper.map(object, clazz);
	}

}
