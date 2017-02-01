package com.programcreek.helloworld.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.programcreek.helloworld.bean.TicketDetails;
import com.programcreek.helloworld.bean.UserDetails;
import com.programcreek.helloworld.exception.UscException;
@Repository
public class jpDao implements IjpDao{

	//@Autowired
	//SimpleJdbcTemplate simpleJdbcTemplate;
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	
	
	public String add(UserDetails login) {
		// TODO Auto-generated method stub
	/*	
	System.out.println("dao1");
		String sql="INSERT into userdetails VALUES(?,?,?)";
		Object[] params=new Object[]{"sam","dsa","a"};
		System.out.println("dao2");
		int res=simpleJdbcTemplate.update(sql,params);
		System.out.println("dao3");
		*/
		jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");
		return"success";
	}


	public int validate(UserDetails user) throws UscException {
		
		
		System.out.println("dao1");
		String sql="select * from userdetails where name=? and password=?";
		System.out.println("dao2");
		try{
		@SuppressWarnings("deprecation")
		
		UserDetails usr = (UserDetails)jdbcTemplate.queryForObject(
				sql, new BeanPropertyRowMapper<UserDetails>(UserDetails.class),
				new Object[] { user.getName(),user.getPassword() });
		System.out.println("dao2");
		System.out.println(usr.getName());
		}
		catch (DataAccessException e) {
			throw  new UscException("user does not exist");
		}
		
		/*
		System.out.println("iside validate");
		jdbcTemplate.execute("create table mytable (id integer, name varchar(100))");*/
		return 1;
	}



	public List<String> categoryvalue(String value,String category) {
		String sql="select distinct sub_category from category_list where function=? and category=?";
		List<String> res = jdbcTemplate.queryForList(sql, String.class, new Object[] { value,category });
		return res;
	}



	public List<String> functionvalue(String value) {
		// TODO Auto-generated method stub
		String sql="select distinct category from category_list where function=?";
		
		List<String> res = jdbcTemplate.queryForList(sql, String.class, value);
		return res;
	}



	public boolean addticket(TicketDetails details) {
		// TODO Auto-generated method stub
		return true;
	}

}
