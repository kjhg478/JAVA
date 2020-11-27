<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>
		<a href="JoinForm.jsp">회원가입 페이지로</a>
	</h1>
	<h1>
		<a href="memberList">회원조회 페이지로</a>
	</h1>

	<!-- 로그인 안했을 시 -->
	<c:if test="${loginId eq null}">
		<h1>
			<a href="Login.jsp">로그인 페이지로</a>
		</h1>
	</c:if>
	
	<!-- 로그인 했을 시 -->
	<c:if test="${loginId ne null}">
		<h1>
			<a href="logout">로그아웃</a>
		</h1>
	</c:if>

	<hr />
	<button onclick="writeForm()">게시판 글 작성하기</button>
	<button onclick="pageList()">게시판 목록보기</button>
</body>

<script>
	function writeForm() {
		location.href = "BoardWrite.jsp";
	}

	function pageList() {
		location.href = "pagingList";
	}
</script>
</html>