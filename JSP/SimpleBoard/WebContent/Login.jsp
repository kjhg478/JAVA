<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td, th {
	border: 2px solid black;
	border-collapse: collapse;
	margin: auto;
}

table {
	width: 400px;
	height: 150px;
}

td, th {
	padding: 5px;
}

button, input#login {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	smargin-right: -4px;
	border: 2px solid skyblue;
	background-color: rgba(0, 0, 0, 0);
	color: black;
	padding: 5px;
	width: 100px;
	height: 40px;
}

button:hover, input#login:hover {
	background: aqua;
}
</style>
</head>
<body>
	<table>
		<form action = "LoginController" method = "POST" autocomplete="on">
		<th colspan="2">로그인 페이지</th>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId" required size="37" placeholder ='UserID' autofocus></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="userPw" required size="37" placeholder ='UserPW'></td>
		</tr>

		<tr>
		
		<tr style="text-align: center;">
			<td colspan="3">
				<input type="submit" value="로그인" id="login" style='cursor: pointer;' >
			</form>	
				<button onclick="location.href ='Join.jsp'" style='cursor: pointer;'>회원가입</button>
			</td>
		</tr>
	</table>

</body>
<script>

</script>



</html>