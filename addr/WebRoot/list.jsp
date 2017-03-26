<%@page import="entity.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>list</title>

  </head>
  
  <body>
  	欢迎,${name } &nbsp;&nbsp;当前在线用户数:${applicationScope.counter}
  	<table border="1">
  		<tr><td>Name</td><td>Street</td><td>City</td><td>State</td><td>Zip</td><td>Option</td></tr>
    	<c:forEach var="a" items="${list}">
    	<tr><td>${a.name}</td><td>${a.street}</td><td>${a.city}</td><td>${a.state }</td><td>${a.zip }</td>
    	<td><a href="AddressServlet?method=delete&id=${a.id }">Delete</a>
    		<a href="AddressServlet?method=toedit&id=${a.id }">Edit</a>
    	</td>
    	</tr>
    	</c:forEach>
    </table>
    	<a href="add.html">add</a>
  </body>
</html>
