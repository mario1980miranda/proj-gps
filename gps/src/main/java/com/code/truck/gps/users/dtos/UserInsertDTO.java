package com.code.truck.gps.users.dtos;

import com.code.truck.gps.users.validations.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO {

	private String password;
	
	public UserInsertDTO() {
		super();
	}

	public UserInsertDTO(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
