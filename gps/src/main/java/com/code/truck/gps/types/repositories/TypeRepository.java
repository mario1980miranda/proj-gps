package com.code.truck.gps.types.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.code.truck.gps.types.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

	@Query("SELECT t FROM Type t WHERE t.type.id IS NULL")
	public List<Type> findAllParents();
	
	public List<Type> findByTypeId(final Long idParent);
}
