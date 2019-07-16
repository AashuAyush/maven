<%@page import="com.visa.prj.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv = "Content-Type" content ="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
<h1>Guessing Game</h1>
<p>What is my name?</p> <br/>
	<%

	List<Product> products = (List<Product>) request.getAttribute("products");
		for (Product p : products){
	%>
	<tr>
		<td><%= p.getId() %> </td>
		<td><%= p.getName() %> </td>
		<td><%= p.getPrice() %> </td>
	</tr>
	<%
		}
	%>
<p>Answer : ********* <br /> Life counts : 5</p>
	
	</table>
</body>
</html>