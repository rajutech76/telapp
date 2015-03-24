<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

		 <table border="1" align="center" style="width:50%">
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
				<c:forEach items="${auroList}" var="auro">
				 <tr>
					 <td><c:out value="${auro.auroLogId}" /></td>
					 <td><c:out value="${auro.deviceName}" /></td>
					 <td><c:out value="${auro.deviceMacId}" /></td>
					 <td><c:out value="${auro.slotname}" /></td>
					 <td><c:out value="${auro.slotstatus}" /></td>
					 <td><c:out value="${auro.createdTime}" /></td>				
				 </tr>
			</c:forEach>
			</tbody>			
		 </table>		
		 <br/>
	 </div>
</center>		
</body>
</html>