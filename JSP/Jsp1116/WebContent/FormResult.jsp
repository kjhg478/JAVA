<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "stuInfo1" method = "GET">
	<h1>FormResult page</h1>
	<h2>Dispatcher 방식</h2>
	이름 : <%=request.getAttribute("sName1") %> <br>
	아이디 : <%=request.getAttribute("sId1") %> <br>
	임의의 값 : <%=request.getAttribute("sInfo1") %>
	</form>
</body>
</html>