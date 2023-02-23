<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ page import="java.sql.*" %>
<%
String login="";
  if(session.getAttribute("login")!=null){
	  login = session.getAttribute("login").toString();
  }else{
	  response.sendRedirect("welcome.jsp");
  }

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>

<div align="right"> 
    Bonjour <%=login %><br>
    <a href="Logout">Accueil</a>
 </div>
</body>

</body>
</html>