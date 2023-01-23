<%@page import="java.util.ArrayList"%>
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
<h1>HERE THE BOOKS ARE</h1>
<table border="2px solid black">
        <tr>
        <th>Book_id</th>
        <th>Book_name</th>
        <th>Author_name</th>
        <th>No_of_pages</th>
        <th>pages</th>
        <th>delete</th>
        <th>update</th>
        </tr>
   <% ArrayList<Book> books=(ArrayList)request.getAttribute("data");
   for(Book b:books){%>
   <tr>
   <td><%= b.getBook_id() %></td>
   <td><%= b.getBook_name() %></td>
   <td><%=b.getAuthor_name() %></td>
   <td><%=b.getPages() %></td>
   <td><%=b.getPrice() %></td>
    <td><a href="delete?id=<%=b.getBook_id()%>">delete</a></td>
    <th><a href="update?id=<%=b.getBook_id()%>">edit</a></th>
    
   </tr>
   <%} %>
	 </table>
	 <h2><a href="welcome.html">home</a></h2>
</body>
</html>