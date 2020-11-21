<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td, tr, th {
	margin: auto;
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
	padding: 4px;
}
</style>
</head>
<body>
	<form action="LoginController" method='POST'>
		<table>
			<tr>
				<th colspan="2">로그인</th>
			</tr>
			<tr>
				<th>ID</th>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<th>PASS</th>
				<td><input type="password" name="userPwd"></td>
			</tr>

			<tr>
				<th colspan="2"><input type="submit" value="로그인"></th>
			</tr>
		</table>
	</form>



</body>
</html>