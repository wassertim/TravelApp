<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.TravelDestination"%>
<%
	ArrayList<TravelDestination> travelDestinations = (ArrayList<TravelDestination>)request.getAttribute("travelDestinations");
%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../../header.jsp" %>
</head>
<body>
	<%@include file="../../navigation.jsp" %>
	<h1><%=request.getAttribute("pageTitle") %></h1>
	<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Country ID</th>
			<th>Command</th>
		</tr>
	</thead>
	<% for(TravelDestination travelDestination : travelDestinations){ %>
	<tr>
		<td><%= travelDestination.getBenutzer() %></td>
		<td><%= travelDestination.getCountryId() %></td>
		<td><a href="RemoveTravelDestination?id=<%=travelDestination.getId()%>">Löschen</a></td>
	</tr>
	<% } %>
	</table>
</body>
</html>
