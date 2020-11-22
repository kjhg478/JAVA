<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String[] info = (String[])request.getAttribute("info"); %>
<% int n = info.length; %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for(String info1 : info) { %>
		<%=info1 %>
	<% } %> 
	
	<c:forEach var = "info2" items = "${info }"  >
		${ info2 }
	</c:forEach>
</body>
</html>