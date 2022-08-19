package com.code.truck.gps.types.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.code.truck.gps.types.dtos.TypeDTO;
import com.code.truck.gps.types.entities.Type;
import com.code.truck.gps.types.repositories.TypeRepository;

@Service
public class TypeService {

	private static Logger logger = LoggerFactory.getLogger(TypeService.class);
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Transactional(readOnly = true)
	public Page<TypeDTO> findAll(Pageable page) {
		final Page<Type> types = this.typeRepository.findAll(page);
		return types.map(x -> new TypeDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<TypeDTO> findAllParents() {
		final List<Type> parents = this.typeRepository.findAllParents();
		return parents.stream().map(x -> new TypeDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<TypeDTO> findByParent(final Long typeId) {
		final List<Type> types = this.typeRepository.findByTypeId(typeId);
		return types.stream().map(x -> new TypeDTO(x)).collect(Collectors.toList());
	}
}
