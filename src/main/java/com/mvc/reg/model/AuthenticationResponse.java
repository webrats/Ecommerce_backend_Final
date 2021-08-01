package com.mvc.reg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	private long id  ;
	private String token ;
	private String email ;
	private String role ;
	private int expirationDateInMs ;
	
	
	public AuthenticationResponse() {
		
	}
	
	public AuthenticationResponse(String token) {
		super();
		this.token = token;
	}
	

	
	

	public AuthenticationResponse(long id, String token, String email, String role, int expirationDateInMs) {
		super();
		this.id = id;
		this.token = token;
		this.email = email;
		this.role = role;
		this.expirationDateInMs = expirationDateInMs;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExpirationDateInMs() {
		return expirationDateInMs;
	}

	public void setExpirationDateInMs(int expirationDateInMs) {
		this.expirationDateInMs = expirationDateInMs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
}
