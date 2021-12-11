<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp" %>
</head>
<body>
	<%@include file="../navigation.jsp" %>
	<h1><%=request.getAttribute("pageTitle") %></h1>

	<form action="<%= request.getContextPath() %>/NewCountry" method="post">
		<div>
			Landtitel: &nbsp;<input type="text" name="title"/>
		</div>
		<div>
			<input type="submit" value="Abspeichern"/>
		</div>
	</form>
</body>
</html>
