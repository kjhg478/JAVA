<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,td,tr,th{
margin: auto;
border: 1px solid black;
border-collapse: collapse;
text-align: center;
padding: 4px;
}
</style>
</head>
<body>
<form action="memberJoin" method = 'POST'>
	<table>
	<tr><th colspan="2">회원 가입</th></tr> 
	<tr><th>ID</th><td> <input type="text" name="id"></td></tr>
	<tr><th>PASS</th><td> <input type="password" name="pwd"></td></tr>
	<tr><th>NAME</th><td> <input type="text" name="name"></td></tr>
	<tr><th>Birthday</th><td> <input type="date" name="birth"></td></tr>
	<tr><th>Gender</th><td> 남<input type="radio" name="gender" value="남자"> 여<input type="radio" name="gender" value="여자"></td></tr> 
	<tr><th>Email</th><td> <input type="email" name="email"></td></tr>
	<tr><th colspan="2"> <input type="submit" value="회원가입"></th> </tr>
	</table>
	</form>
</body>
</html>








