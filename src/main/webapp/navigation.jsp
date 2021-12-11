<%
	String username=null;
	if(session!=null){
		username= (String)session.getAttribute("loggedInUsername");
	}
%>

<div>
	<a href="Index">Home</a> |
<% if(username!=null&&username.toLowerCase().equals("admin")){ %>
	<a href="CountryList">Alle Laender</a> |
	<a href="TravelDestinationsAdmin">Laender bereist verwalten</a> |
<% } %>
	<a href="TravelDestinations">Laender bereist</a> |
<% if(username==null||username.equals("")){ %>
	<a href="LoginUser">Login</a>
<% } else { %>
	Hallo <%= username %>:
	<a href="Logout">Ausloggen</a>
<% } %>
</div>
