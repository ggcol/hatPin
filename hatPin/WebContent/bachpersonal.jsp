<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.LinkedList"
    import = "it.abupro.LatLng.function.WallHelper" 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PERSONAL PINS</title>
</head>
<body>

<form action="bachpersonal.jsp">
<input type="text" name="username">
<input type="submit" value="Carica!"></form>

<% String username = request.getParameter("username"); 
if (username != null) {%>

<% WallHelper wh = new WallHelper();
LinkedList<String> read = wh.importPin4Personal(username); %>

<%! int flag = 0; %>		 
<%  for (int i = 0; i < read.size(); i = i+4) {
	String latlng = read.get(i);
	String title = read.get(i+1);
	String body = read.get(i+2);
	String ref_img = read.get(i+3);
	flag++;
	%>
	<div id = "latlng<%=flag%>"><p>LATLNG <%=flag %>: <%=latlng%></p></div>
	<div id = "title<%=flag%>"><p>TITLE <%=flag %>: <%=title %></p></div>
	<div id = "body<%=flag%>"><p>BODY <%=flag %>: <%=body %></p></div>
	<div id = "ref_img<%=flag%>"><p>IMG <%=flag %>: </p><img src="<%=ref_img%>"></div>
	
<% } %>
<% } %>

</body>
</html>