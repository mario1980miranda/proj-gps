package com.code.truck.gps.types.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.truck.gps.types.dtos.TypeDTO;
import com.code.truck.gps.types.services.TypeService;

@RestController
@RequestMapping(value = "/types")
public class TypeResource {

	@Autowired
	private TypeService typeService;
	
	@GetMapping
	public ResponseEntity<Page<TypeDTO>> findAll(Pageable page) {
		final Page<TypeDTO> dtos = this.typeService.findAll(page);
		return ResponseEntity.ok(dtos);
	}
	
	@GetMapping(value = "/parents")
	public ResponseEntity<List<TypeDTO>> findAllParents() {
		final List<TypeDTO> parents = this.typeService.findAllParents();
		return ResponseEntity.ok(parents);
	}
	
	@GetMapping(value = "/parents/{id}")
	public ResponseEntity<List<TypeDTO>> findByParent(@PathVariable final Long id) {
		final List<TypeDTO> parents = this.typeService.findByParent(id);
		return ResponseEntity.ok(parents);
	}
}
