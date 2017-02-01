package com.programcreek.helloworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programcreek.helloworld.bean.TicketDetails;
import com.programcreek.helloworld.bean.UserDetails;
import com.programcreek.helloworld.dao.IjpDao;
import com.programcreek.helloworld.exception.UscException;
@Service
public class JqService implements IJqService{
	@Autowired
	IjpDao dao;
	
	public String add(UserDetails login) {
		System.out.println("service");
		return dao.add(login);
	}

	public int validate(UserDetails user) throws UscException {
		int res = 0;
		try {
			res = dao.validate(user);
		} catch (UscException e) {
			// TODO Auto-generated catch block
			throw new UscException(e.getMessage());
		}
		return res;
	}

	

	public List<String> categoryvalue(String value,String category) {
		// TODO Auto-generated method stub
		return dao.categoryvalue(value,category);
	}

	public List<String> functionvalue(String value) {
		// TODO Auto-generated method stub
		return dao.functionvalue(value);
	}

	public boolean addticket(TicketDetails details) {
		// TODO Auto-generated method stub
		return dao.addticket(details);
	}

}
