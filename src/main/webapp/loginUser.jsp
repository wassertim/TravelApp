<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="header.jsp" %>
</head>
<body>
	<%@include file="navigation.jsp" %>
	<h1><%=request.getAttribute("pageTitle") %></h1>
	
	<div>Logge dich doch bitte ein, damit deine Daten personalisiert werden können.</div>
	<div>
		<form method="post" action="LoginUser">
			<div>
				<span>Login Name: </span><input type="text" name="loginName"/>
			</div>
			<div>
				<input type="submit" value="Abschicken"/>
			</div>
		</form>
	</div>
</body>
</html>