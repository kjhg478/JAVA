<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 4px;
}
</style>
</head>
<body>
	<h1>MemberList.jsp</h1>
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>이메일</th>
			<th>상세조회</th>
			<th>탈퇴</th>

		</tr>
		<C:forEach items="${list}" var="list">
		<!-- list 는 서블릿에서 정해준 변수 이름 → (request.setAttribute("list", list);-->
			<tr>
			<th>${list.userId}</th>
			<th>${list.userPwd}</th>
			<th>${list.userName}</th>
			<th>${list.userBirth}</th>
			<th>${list.userGender}</th>
			<th>${list.userEmail}</th>
			<th>상세조회</th>
			<th>탈퇴</th>
		</tr>
		</C:forEach>
	</table>
</body>
</html>












