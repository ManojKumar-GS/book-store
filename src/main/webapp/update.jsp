<%@page import="com.js.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ENTER BOOK DETAILS TO UPDATE</h1>
	<% Book bo=(Book)request.getAttribute("book"); %>
	<form action="updatestage2">
	BOOK_ID : <input type="number" name="id" value="<%=bo.getBook_id()%>" readonly="readonly"><br><br>
	BOOK_NAME : <input type="text" name="bookname" value="<%= bo.getBook_name()%>"><br> <br>
	AUTHOR_NAME : <input type="text" name="authorname" value="<%= bo.getAuthor_name()%>"><br><br>
	PAGES :<input type="number" name="pages" value="<%= bo.getPages()%>"><br><br>
	PRICE : <input type="number" name="price" value="<%=bo.getPrice()%>"><br><br>
	<input type="submit" value="update">
	</form>
	<h2><a href="welcome.html">home</a></h2>
</body>
</html>