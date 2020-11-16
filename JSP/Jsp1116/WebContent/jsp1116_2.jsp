<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% // 이 안에 Java코드를 사용할 수 있습니다. %>
<% int num = 0; %>
<%@page import = "java.util.Date" %>


<%
	// 자바코드 작성
	// hour, min, sec
	Date now = new Date();
	int a = now.getHours();
	int b = now.getMinutes();
	int c = now.getSeconds();

%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	현재시간 : <%=a %>시 <%=b %>분 <%=c %>초 <br/>
	
	JSP / Servlet <br/>
	num : <%= num %> <br/><br/>
	
	
</body>
</html>