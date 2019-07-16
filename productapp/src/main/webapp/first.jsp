<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-Type" content ="text/html; charset=UTF-8">
<title>First page</title>
</head>
<body>
	<h1>
		Unicode characters &#2309;
		</h1>
		
	<%
	for (int i = 2305; i < 3200; i++){ 
	%>
		<br /> Character : &#<%= i %>; for the value <%= i %>
		
	<%
	}
	%>
	
</body>
</html>