<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>기본 GET방식</h1>
	<h3>request.getParameter : <%=request.getParameter("eLname") %>></h3>
	
	<h1>EL 방식</h1>
	<h3>param : ${param.eLname}</h3>
</body>
</html>