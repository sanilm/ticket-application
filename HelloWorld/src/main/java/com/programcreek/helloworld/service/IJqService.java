package com.programcreek.helloworld.service;

import java.util.List;

import com.programcreek.helloworld.bean.TicketDetails;
import com.programcreek.helloworld.bean.UserDetails;
import com.programcreek.helloworld.exception.UscException;

public interface IJqService {

	public String add(UserDetails login);
	public int validate(UserDetails user) throws UscException;
	
	public List<String> categoryvalue(String value,String category);
	public List<String> functionvalue(String value);
	public boolean addticket(TicketDetails details);
}
