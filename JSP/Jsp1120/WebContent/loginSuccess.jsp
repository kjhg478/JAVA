<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> <%=session.getAttribute("loginId") %>님 환영합니다. </h2>
<%--
자바 코드 다른 사용법
${loginId}  
${sessionScope.loginId} 
--%>
</body>
</html>