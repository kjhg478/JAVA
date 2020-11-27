<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="usermod" method="POST">
		비밀번호 : <input type="password" name="pwd"><br/>
		이름 : <input type="text" name="name"><br/>
		이름 : <input type="email" name="email"><br/>
		<button onclick="location.href='usermod'">수정</button>
	</form>
	
</body>
</html>