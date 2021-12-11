<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,viewmodel.CountryViewModel"%>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>
<% ArrayList<CountryViewModel> countries = (ArrayList<CountryViewModel>)request.getAttribute("countries"); %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../header.jsp" %>
</head>
<body>
<%@include file="../navigation.jsp" %>
<h1><%=request.getAttribute("pageTitle") %></h1>
<form method="POST">
        <table>
            <% for(CountryViewModel countryViewModel : countries){ %>
            <tr>
                <td>
                <% if(countryViewModel.isTraveled()) { %>
                    <input type="checkbox" disabled checked />
                <% } else { %>
                    <input type="checkbox" name="countryId" value="<%= countryViewModel.getCountry().getId()%>" />
                <% } %>
                </td>
                <td><%= countryViewModel.getCountry().getTitle()%></td>
            </tr>
            <% } %>
        </table>
        <button type="submit">Auswahl speichern</button>
</form>
</body>
</html>
