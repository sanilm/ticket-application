package com.programcreek.helloworld.bean;

import org.springframework.stereotype.Component;

@Component

public class UserDetails {

	private String name;
	private String password;
	private String drp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDrp() {
		return drp;
	}
	public void setDrp(String drp) {
		this.drp = drp;
	}
	
	
	
	
	
}
