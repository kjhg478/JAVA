<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="stuInfo" method="POST">
	<fieldset>
		<legend>학생 정보</legend>
		이름 : <input type ="text" name="sName"><br>
		아이디 : <input type = "text" name = "sId"><br>
		임의의 값 : <input type = "text" name = "value">
	</fieldset>
	<input type="submit" value="제출">
	</form>
</body>
</html>