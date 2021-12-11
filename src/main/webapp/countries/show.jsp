<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Country"%>
<%
	Country country = (Country)request.getAttribute("country");
%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp" %>
</head>
<body>
	<%@include file="../navigation.jsp" %>
	<h1><%=request.getAttribute("pageTitle") %></h1>
	<form method="POST">
		<input type="hidden" name="id" value="${country.getId()}" />
		<table>
			<tr>
				<td>Titel</td>
				<td><input type="text" value="${country.getTitle()}" name="title" /></td>
			</tr>
		</table>
		<button type="submit">Abspeichern</button>
	</form>
</body>
</html>
