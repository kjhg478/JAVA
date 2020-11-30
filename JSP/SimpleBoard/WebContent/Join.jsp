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
	width : 400px;
	height : 500px;
}

td, th {
	padding: 5px;
}
input#join {
	border-top-left-radius: 5px; 
	border-bottom-left-radius: 5px; 
	smargin-right:-4px;
	border: 2px solid skyblue; 
	background-color: rgba(0,0,0,0); 
	color: black; 
	padding: 5px;
	width : 100px;
	height : 40px;


}
input#join:hover {
	background : aqua;
	
}
</style>
</head>
<body>
	<form action = "JoinController" Method = "POST">
	<table>
		<tr>
			<th colspan="2">회원 가입</th>
		</tr>
		<tr>
			<th>ID</th>
			<td><input type="text" name="userId" required size="30"></td>
		</tr>
		<tr>
			<th>PassWord</th>
			<td><input type="Password" name="userPw" required id="userPw" size="30"></td>
		</tr>
		<tr>
			<th>PassWord Check</th>
			<td><input type="Password" name="checkPw" required id ="checkPw" onkeyup="check1()" size="30"></td>
		</tr>
		<tr>
			<th colspan = "2"><h3 id="msg"></h3></th>
		</tr>
		<tr>
			<th>Name</th>
			<td><input type="text" name="userName" required size="30"></td>
		</tr>
		<tr>
			<th>Gender</th>
			<td>남자<input type="radio" name="userGender" required value="남자"> 여자<input
				type="radio" name="gender" value="여자"></td>
		</tr>
		<tr>
			<th>Birthday</th>
			<td><input type="date" name="userBirth" required size="30"></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><input type="text" name="userEmail" required size="30"></td>
		</tr>

		<tr>
		<tr style="text-align: center;">
			<th colspan="2"><input type = "submit" value ="회원가입" id="join" style='cursor:pointer;'></th>
		</tr>
	</table>
	</form>

</body>
<script>
	var pw1;
	var pw2;
	
	function check1() {
		pw1 = document.getElementById("userPw").value;
		pw2 = document.getElementById("checkPw").value;
		var msg = document.getElementById("msg");
			if(pw1==pw2) {
				msg.innerHTML = "가능한 비밀번호다";
			}else {
				msg.innerHTML = "다시 입력해라"
			}

	}


</script>


</html>