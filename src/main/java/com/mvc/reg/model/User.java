package com.mvc.reg.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="users")
public class User {

	@Id
	private long id ;
	private String name ;
	private String email ;
	private String password ;
	private String created_at ;
	private String login_token ;
	private int type ;
	private String address ;
	private int is_email_varified;
	private String mobile ;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getLogin_token() {
		return login_token;
	}
	public void setLogin_token(String login_token) {
		this.login_token = login_token;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIs_email_varified() {
		return is_email_varified;
	}
	public void setIs_email_varified(int is_email_varified) {
		this.is_email_varified = is_email_varified;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
