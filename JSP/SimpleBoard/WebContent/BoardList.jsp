<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td, th, c {
	border: 2px solid black;
	border-collapse: collapse;
	margin: auto;
}

table {
	width: 1200px;
	height: 60px;
}

td, th {
	padding: 5px;
}

button {
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

button:hover {
	background: aqua;
}
</style>
</head>
<body>

	<table>
		<caption>
			<h1>BoardList.jsp</h1>
		</caption>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>글 삭제</th>

		</tr>
		<!-- list 는 서블릿에서 정해준 변수 이름 → (request.setAttribute("list", list);-->
		<c:forEach items="${boardList}" var="list">

			<tr>
				<th>${list.num}</th>
				<td><a href="BoardDetailController?num=${list.num}">${list.title}</a></td>
				<th>${list.name}</th>
				<th>${list.date}</th>
				<th>글 삭제</th>

			</tr>
		</c:forEach>

	</table>

	<table>
		<tr>
			<th><button style='cursor: pointer;' onclick="logout()">로그아웃</button></th>
			<th><button style='cursor: pointer;' onclick="back()">뒤로가기</button></th>
		</tr>
		<tr>
			<th colspan = "2">
			<!-- 페이징 처리 -->

			<!-- 현재 페이지 1페이지 이거나 1페이지보다 작은 경우 -->
			<c:if test="${paging.page<=1}">[이전]&nbsp;</c:if>

			<!-- 현재 페이지가 1페이지 보다 클 경우 -->
			<c:if test="${paging.page>1}">
				<a href="BoardListController?page=${paging.page-1}">[이전]</a>&nbsp;
	</c:if>

			<!-- 현재 페이지 표시 -->
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
				var="i" step="1">
				<c:choose>

					<c:when test="${i eq paging.page}">
				${i}
			</c:when>


					<c:otherwise>
						<a href="BoardListController?page=${i}">${i}</a>

					</c:otherwise>

				</c:choose>

			</c:forEach>

			<!-- 현재 페이지가 끝페이지 이거나 끝페이지보다 큰 경우 -->
			<c:if test="${paging.page >= paging.maxPage}">&nbsp;[다음]</c:if>

			<!-- 현재 페이지가 끝페이지보다 작은 경우 -->
			<c:if test="${paging.page < paging.maxPage}">
			&nbsp;<a href="BoardListController?page=${paging.page+1}">[다음]</a>
			</c:if>
			</th>
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