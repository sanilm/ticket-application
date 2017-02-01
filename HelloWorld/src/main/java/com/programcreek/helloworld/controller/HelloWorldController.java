package com.programcreek.helloworld.controller;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.programcreek.helloworld.bean.TicketDetails;
import com.programcreek.helloworld.bean.UserDetails;
import com.programcreek.helloworld.exception.UscException;
import com.programcreek.helloworld.service.IJqService;

@RestController
@EnableWebMvc
public class HelloWorldController {

	String message = "Welcome to Spring MVC!";
	@Autowired
	 UserDetails usr;
	@Autowired
	HttpSession session;
	
	
	@Autowired
	IJqService ij;
	
	@RequestMapping("/hello")	
	public ModelAndView showMessage(ModelAndView mav) {	
		UserDetails user=new UserDetails();	
		System.out.println("************"+user.getName());	
		mav.setViewName("helloworld");
	    mav.addObject("login", new UserDetails());		
	    return mav;
	}
	
	
	@RequestMapping("/usermod")	
	public ModelAndView userticket(ModelAndView mav) {	
		//UserDetails user=new UserDetails();	
		//System.out.println("************"+user.getName());	
		//mav.setViewName("userticketraise");
		System.out.println("session details");
		
		System.out.println(session.getAttribute("username"));
		//session.invalidate();
		mav.setViewName("useroptions");
		System.out.println("usermod");
	    //mav.addObject("login", new UserDetails());		
	    return mav;
	}
	
	@RequestMapping("/raisenewticket")	
	public ModelAndView newticket(ModelAndView mav) {	
		//UserDetails user=new UserDetails();	
		//System.out.println("************"+user.getName());
		System.out.println("session details");
		System.out.println(session.getAttribute("username"));
		mav.setViewName("userticketraise");
		//mav.setViewName("useroptions");
		List<String> category1=new ArrayList<String>();
		category1.add("admin");
		category1.add("hr");
		System.out.println("usermod");
		mav.addObject("category", category1);
	    mav.addObject("login", new TicketDetails());	
	    
	    return mav;
	}
	
	
	
	@RequestMapping(value="/loginvalidate" , method = RequestMethod.POST)
	public  ModelAndView loginvalidate(@ModelAttribute("login")  UserDetails login,Model model,HttpServletRequest request, HttpServletResponse response,ModelAndView mav)	
	{	int res=0;
		try {
			res=ij.validate(login);
		} catch (UscException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		if(res==0){
		mav.setViewName("helloworld");
	    mav.addObject("login", new UserDetails());		
	    return mav;	}
		else{
			session.setAttribute("username", login.getName());
			mav.setViewName("adminuserop");
	   // mav.addObject("login", new UserDetails());	
	    return mav;
		}
	}
	
	
	@RequestMapping(value="/processLogin" , method = RequestMethod.POST,produces = "application/json",consumes="application/json")
	//@RequestMapping(value="/processLogin" , method = RequestMethod.POST,headers = "text/plain")
	//@RequestMapping(value="/processLogin" , method = RequestMethod.POST,headers = "Accept=*/*")
	//@RequestMapping(value="/processLogin" , method = RequestMethod.POST)
	//@RequestMapping(value="/processLogin" , method = RequestMethod.POST,produces = "text/html")
	
	
	public @ResponseBody List<String> processLoginForm(@RequestBody  TicketDetails login,Model model,HttpServletRequest request, HttpServletResponse response)
	
	
	//public  String processLoginForm(@ModelAttribute("login") UserDetails login,Model model)
	
	{	System.out.println("in controller");
	//response.setContentType("application/json");
	List<String> list=new ArrayList<String>();
	if(login.getFunction() != null && login.getCategory()==null)
	{
		list=ij.functionvalue(login.getFunction());
		return list;
	}
	
	
	
	else
	{
		list=ij.categoryvalue(login.getFunction(),login.getCategory());
		return list;
	}
	
	//System.out.println(login.getFunction());
	//System.out.println(login.getCategory());
	//System.out.println(login.getSub_category());
	//System.out.println(login.getPriority());
	//System.out.println(login.getSubject());
	//System.out.println(login.getDescription());
	//System.out.println(login.getOnbehalfid());
	//System.out.println(login.getCurrent_location());
	//System.out.println(login.getPhone_number());
		//System.out.println(login.getName());
		//System.out.println(ij.add(login));
		//response.setContentType("application/json");
		//ArrayList<UserDetails> al=new ArrayList<UserDetails>();
		//al.add(login);
		//usr.setName("sanil");
		//usr.setPassword("hello");
		//String json = "[{\"name\": \"Jason\",\"number\": \"10\" }, {\"name\": \"Jimmy\",\"number\": \"11\" }]";
		//System.out.println(json);
		//al.add(usr);
		//ij.add(login);
		//System.out.println("**************Model model");
		//model.addAttribute("usrbean", usr);
		//System.out.println("**************usrbean");
		//model.addAttribute("coll",al);
		//System.out.println("**************last lines");
		// return "{\"success\":1}";
		//LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		//states.put("one", "Alabama");
		//states.put("two", "Alaska");
		//states.put("three", "Arizona");
		
		
		//List<String> lst=new ArrayList<String>();
		//lst.add("alaska");
		//lst.add("alaska1");
		//lst.add("alaska2");
		//return new Response(al);
		 //return lst;
		//return Json (new{ al = al }, JsonRequestBehavior.AllowGet);
		//return "allticket";
		
	}
	
	
	@RequestMapping(value="/addticket" , method = RequestMethod.POST,produces = "application/json",consumes="application/json")

	public @ResponseBody String addticket(@RequestBody  TicketDetails login,Model model,HttpServletRequest request, HttpServletResponse response)
	{
		
		
		System.out.println(login.getFunction());
		System.out.println(login.getCategory());
		System.out.println(login.getSub_category());
		System.out.println(login.getPriority());
		System.out.println(login.getSubject());
		System.out.println(login.getDescription());
		System.out.println(login.getOnbehalfid());
		System.out.println(login.getCurrent_location());
		System.out.println(login.getPhone_number());
			Boolean status=ij.addticket(login);
			if(status==true)
			{
				return "ticket raised successfully";
			}
		
		
		return message;
		
	}
	
	
	
	
	
	
	
	
	}


