<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.Country"%>
<%
	ArrayList<Country> countries = (ArrayList<Country>)request.getAttribute("countries");
%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../header.jsp" %>
</head>
<body>
	<%@include file="../navigation.jsp" %>
	<h1><%=request.getAttribute("pageTitle") %></h1>
	<div>
		<a href="NewCountry">Neues Land erfassen</a>
	</div>
	<table>
	<% for(Country country : countries){ %>
	<tr>
		<td><%= country.getTitle()%></td>
		<td><a href="ShowCountry?id=<%=country.getId()%>">Ändern</a></td>
		<td><a href="RemoveCountry?id=<%=country.getId()%>">Löschen</a></td>
	</tr>
	<% } %>
	</table>
</body>
</html>
