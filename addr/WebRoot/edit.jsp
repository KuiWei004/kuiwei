<!DOCTYPE html>
<%@page import="entity.Address"%>
<html>
  <head>
    <title>add.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
  	<% Address address=(Address)request.getAttribute("address"); %>
    <form action="AddressServlet?method=edit" method="post">
    	<input type="hidden" name="id" value="<%=address.getId()%>">
    	Name:<input type="text" name="name" value="<%=address.getName()%>"><br>
    	Street:<input type="text" name="street" value="<%=address.getStreet()%>"><br>
    	City:<input type="text" name="city" value="<%=address.getCity()%>"><br>
    	State:<input type="text" name="state" value="<%=address.getState()%>"><br>
    	Zip:<input type="text" name="zip" value="<%=address.getZip()%>"><br>
    	<input type="submit" value="Edit">
    </form>
  </body>
</html>
