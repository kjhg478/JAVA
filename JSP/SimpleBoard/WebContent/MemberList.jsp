<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width : 1200px;
	height : 60px;
}

td, th {
	padding: 5px;
}
button {
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
button:hover {
	background : aqua;
	
}
</style>
</head>
<body>
	
	<table>
		<caption><h1>MemberList.jsp</h1></caption>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>탈퇴</th>

		</tr>
		<C:forEach items="${member}" var="list">
		<!-- list 는 서블릿에서 정해준 변수 이름 → (request.setAttribute("list", list);-->
			<tr>
			<th>${list.userId}</th>
			<th>${list.userName}</th>
			<th>${list.userBirth}</th>
			<th>${list.userGender}</th>
			<th>${list.userMail}</th>
			<th>상세조회</th>
			<th>탈퇴</th>
		</tr>
		</C:forEach>
	</table>
	<table>
		<tr>
			<th><button style='cursor:pointer;' onclick ="logout()" >로그아웃</button></th>
			<th><button style='cursor:pointer;' onclick ="back()" >뒤로가기</button></th>
		</tr>
	</table>
</body>
<script>

	function back() {
		history.go(-1);
	}

	function logout() {
		location.href = "LogoutController";
	}
</script>
</html>