<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.LinkedList"
    import = "it.abupro.LatLng.function.WallHelper" 
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LATEST PIN</title>
</head>
<body>

<% WallHelper wh = new WallHelper();
LinkedList<String> read = wh.importPin4Wall(); %>

<%! int flag = 0; %>		 
<%  for (int i = 0; i < read.size(); i = i+5) {
	String latlng = read.get(i);
	String title = read.get(i+1);
	String body = read.get(i+2);
	String ref_img = read.get(i+3);
	String username = read.get(i+4); 
	flag++;
	%>
	<div id = "latlng<%=flag%>"><p>LATLNG <%=flag %>: <%=latlng%></p></div>
	<div id = "title<%=flag%>"><p>TITLE <%=flag %>: <%=title %></p></div>
	<div id = "body<%=flag%>"><p>BODY <%=flag %>: <%=body %></p></div>
	<div id = "ref_img<%=flag%>"><p>IMG <%=flag %>: </p><img src="<%=ref_img%>"></div>
	<div id = "username<%=flag%>"><p>USR <%=flag %>: <%=username %></p></div>
	
<% } %>


</body>
</html>