<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="header.jsp" %>
</head>
<body>
	<%@include file="navigation.jsp" %>
	<h1><%=request.getAttribute("pageTitle") %></h1>

<% if(username==null || username.equals("")) {%>
	<div>Du bist nicht eingeloggt, weshalb dir heir nichts angezeigt wird.</div>
<% } else{ %>
	<div>
		Hallo <%= username %>
	</div>
	<div>
		<p>
			Mit dieser Web-Applikation kannst du <a href="TravelDestinations">Länder wählen</a> die du bereist hast.
		</p>
	</div>
<% } %>
</body>
</html>
