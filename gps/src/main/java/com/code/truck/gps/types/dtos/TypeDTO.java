package com.code.truck.gps.types.dtos;

import javax.validation.constraints.NotBlank;

import com.code.truck.gps.types.entities.Type;

public class TypeDTO {

	private Long id;
	@NotBlank(message = "Required field")
	private String description;
	private String ask;
	private Boolean active;
	private Long parentTypeId;
	
	public TypeDTO() {
		
	}

	public TypeDTO(Long id, @NotBlank(message = "Required field") String description, String ask, Boolean active,
			Long parentTypeId) {
		this.id = id;
		this.description = description;
		this.ask = ask;
		this.active = active;
		this.parentTypeId = parentTypeId;
	}
	
	public TypeDTO(Type entity) {
		this.id = entity.getId();
		this.description = entity.getDescription();
		this.ask = entity.getAsk();
		this.active = entity.getActive();
		this.parentTypeId = entity.getType() != null ? entity.getType().getId() : null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getParentTypeId() {
		return parentTypeId;
	}

	public void setParentTypeId(Long parentTypeId) {
		this.parentTypeId = parentTypeId;
	}
	
}
