<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script>

$(document).ready(function(){	
	$("#sel").change(function(e) {	
	//var name=$('#txt1').val();
	//var password=$('#txt2').val();	
	var data = {}
	//data["name"] = $("#txt1").val();
	//data["password"] = $("#txt2").val();
	data["function"] = $("#sel").val();
	//data["sub_category"] = $("#dropdown").val();
	//var str = $("#login").serialize();	
	$.ajax({		
        type: "POST",
       contentType: "application/json",     
      // Accept: "application/json",             
        url: "./processLogin",
         data: JSON.stringify(data),       
        dataType: "html",     
        success: function (data) {   	
        	 var v = $.parseJSON(data);
        	 console.log(JSON.stringify(v));
        	 alert(v); 	 
        	for (var key in v) {
            		    alert(key + " -> " + v[key]);
        		    console.log(key +""+v[key]);
        		    $("#dropdown").append("<option>" + v[key] + "</option>");      		  
        		}	
        },    
    	   error: function (data) {    	   
 		   console.log(JSON.stringify(data));          	
        }
});
    });  
	



	$("#dropdown").change(function(e) {	
		//var name=$('#txt1').val();
		//var password=$('#txt2').val();	
		var data = {}
		//data["name"] = $("#txt1").val();
		//data["password"] = $("#txt2").val();
		data["function"] = $("#sel").val();
		data["category"] = $("#dropdown").val();
		//var str = $("#login").serialize();	
		$.ajax({		
	        type: "POST",
	       contentType: "application/json",     
	       //Accept: "text/html",             
	        url: "./processLogin",
	         data: JSON.stringify(data),       
	        dataType: "html",     
	        success: function (data) {   	
	        	 var v = $.parseJSON(data);
	        	 console.log(JSON.stringify(v));
	        	 alert(v); 	 
	        	for (var key in v) {
	            		    alert(key + " -> " + v[key]);
	        		    console.log(key +""+v[key]);
	        		    $("#dropdown2").append("<option>" + v[key] + "</option>");      		  
	        		}	
	        },    
	    	   error: function (data) {    	   
	 		   console.log(JSON.stringify(data));          	
	        }
	});
	    });  
	
	
	
	
	$("#btn1").click(function(e) {	
		//var name=$('#txt1').val();
		//var password=$('#txt2').val();	
		var data = {}
		//data["name"] = $("#txt1").val();
		//data["password"] = $("#txt2").val();
		data["function"] = $("#sel").val();
		data["category"] = $("#dropdown").val();
		data["sub_category"] = $("#dropdown2").val();
		data["priority"] = $("#priority").val();
		data["subject"] = $("#txt1").val();
		data["description"] = $("#txt2").val();
		data["onbehalfid"] = $("#txt3").val();
		data["current_location"] = $("#txt4").val();
		data["phone_number"] = $("#txt5").val();
		//var str = $("#login").serialize();	
		$.ajax({		
	        type: "POST",
	       contentType: "application/json",     
	      // Accept: "text/html",             
	        url: "./addticket",
	         data: JSON.stringify(data),       
	       dataType: "html",     
	        success: function (data) {   	
	        	// var v = $.parseJSON(data);
	        	 console.log(JSON.stringify(data));
	        	 alert(data); 	 
	        	//for (var key in v) {
	            	//	    alert(key + " -> " + v[key]);
	        		  //  console.log(key +""+v[key]);
	        		    //$("#dropdown2").append("<option>" + v[key] + "</option>");      		  
	        		//}	
	        },    
	    	   error: function (data) {    	   
	 		   console.log(JSON.stringify(data));          	
	        }
	});
	    });  
	
});


</script>
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>	
<form:form action="loginvalidate" modelAttribute="login" method="POST">

  
<form:select id="sel" path="function">
    <form:option value="0" label="Select an Option" />
    <form:options items="${category}" />
</form:select>

<br/>
  
select mode:
<form:select id="dropdown"  path="category">
<option value="None" selected="Selected">Select first category</option>
</form:select>

<br/>

<br/>
  
select mode:
<form:select id="dropdown2"  path="sub_category">
<option value="None" selected="Selected">Select first category</option>
</form:select>

<br/>
<td>priority :</td>
            <td>
                <form:select id="priority" path="priority">
                  
                  <form:option value="1" label="1" />
                  <form:option value="2" label="2" />
                  <form:option value="3" label="3" />
                </form:select>
            </td>

<br/>

Enter subject <form:input id="txt1" path="subject"/>
<br/>

Enter disciption <form:input id="txt2" path="description"/>
<br/>

Enter Name <form:input id="txt3" path="onbehalfid"/>
<br/>

Enter Name <form:input id="txt4" path="current_location"/>
<br/>

Enter Name <form:input id="txt5" path="phone_number"/>
<br/>

<  <button id="btn1" type="button">Login</button>  

</form:form>
</body>
</html>