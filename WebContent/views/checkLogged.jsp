<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String email = (String) session.getAttribute("userLogged");
	if(email == null || email.equals("")){	
%>
<script>
	window.location.replace("/Web");
</script>
<%
	}
	System.out.print(email);
%>