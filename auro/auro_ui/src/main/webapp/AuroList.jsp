<%--
Document : index
Created on : Nov 5, 2012, 6:06:23 PM
Author	 : mano
--%>

<%@page import="java.util.List"%>
<%@page import="org.app.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link rel="stylesheet" type="text/css" href="style.css"/>
	 <title>Home Page</title>	
</head>
<body>
<center>
	 <div id="mystyle">
		 <h1>Auro Sensor Logs </h1>
		 <p>
		 </p>

		 <table>
			 <thead>
				 <tr>
				 
					 <th>Log Id</th>
					 <th>Device Name</th>
					 <th>Device MAC Id</th>
					 <th>Slot Name</th>
					 <th>Slot Status</th>	
					 <th>Create Time</th>				
				 </tr>
			 </thead>
			 <tbody>
				 <%
					 LoginService loginService = new LoginService();
					 List<User> list = loginService.getListOfUsers();
					 for (User u : list) {
				 %>
				 <tr>
					 <td><%=u.getUserId()%></td>
					 <td><%=u.getFirstName()%></td>
					 <td><%=u.getMiddleName()%></td>
					 <td><%=u.getLastName()%></td>
					 <td><%=u.getEmail()%></td>
					 <td><%=u.getEmail()%></td>
				 </tr>
				 <%}%>
			 <tbody>
		 </table>		
		 <br/>
	 </div>

</center>		
</body>
</html>