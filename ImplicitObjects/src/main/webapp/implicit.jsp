<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String responseCheck=request.getParameter("office");
if(responseCheck!=null)
{
response.setStatus(response.SC_MOVED_TEMPORARILY);
response.setHeader("Location","response-redirect.jsp?office="+responseCheck);
}
%>
<% 
String error = request.getParameter("error");
if(error!=null)
{
throw new RuntimeException("Exception occured");	
}
%>
<a href="implicit.jsp?error=1">Check the use of exception object</a>
<% 
String serverName = request.getServerName();
out.print("Server name"+serverName+"<br>");
out.print("Servlet name:"+config.getServletName()+"<br>");
out.print("Servlet info"+application.getServerInfo()+"<br");
out.print("Page details"+page.toString()+"<br");
pageContext.setAttribute("userid","test@gmail.com");
out.print("Page Context Attribute"+pageContext.getAttribute("userid"));
%>
</body>
</html>