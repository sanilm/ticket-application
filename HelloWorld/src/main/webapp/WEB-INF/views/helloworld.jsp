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
/*
$(document).ready(function(){	
	$("#btn1").click(function(e) {	
	var name=$('#txt1').val();
	var password=$('#txt2').val();	
	var data = {}
	data["name"] = $("#txt1").val();
	data["password"] = $("#txt2").val();
	data["drp"] = $("#dropdown").val();
	var str = $("#login").serialize();	
	$.ajax({		
        type: "POST",
       contentType: "application/json",     
       Accept: "text/html",             
        url: "./processLogin",
         data: JSON.stringify(data),       
        dataType: 'html',     
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
});
*/
</script>
<title>Spring 4 MVC -HelloWorld</title>
</head>
<body>	
<form:form action="loginvalidate" modelAttribute="login" method="POST">
Enter Name <form:input id="txt1" path="name"/>
<br/>
Enter Password <form:input id="txt2" path="password"/>
<br/>
<!--  
select mode:
<form:select id="dropdown"  path="drp">
<option value="None" selected="Selected">Select type</option>
</form:select>
-->
<br/>
<!--  <button id="btn1" type="button">Login</button>  -->
<input id="btn1" type="submit" value="Login"/>
</form:form>
</body>
</html>