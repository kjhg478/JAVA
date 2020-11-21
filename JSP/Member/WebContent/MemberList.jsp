<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		table,tr,td,th{
			border : 1px solid black;
			border-collapse : collapse;
		}
		tr,td,th{
			padding : 5px
		}
	</style>
</head>
<body>
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
		<c:forEach items="${member1}" var="mem"> <!-- bean에 있는 정보랑 맞춰줘야 함  -->
			<tr>
				<td>${mem.userId}</td>
				<td>${mem.userPwd}</td>
				<td>${mem.userName}</td>
				<td>${mem.userBirth}</td>
				<td>${mem.userGender}</td>
				<td>${mem.userEmail}</td>
				<td>상세조회</td>
				<td>탈퇴</td>
				
			</tr>	
		</c:forEach>
		
	
	</table>
<%-- 	<%=request.getAttribute("id") %> <%=request.getAttribute("pw") %> <%=request.getAttribute("name") %>
	<%=request.getAttribute("birth") %> <%=request.getAttribute("gender") %> <%=request.getAttribute("email") %> --%>
	
</body>
</html>