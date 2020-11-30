<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
table, tr, td, th {
	border: 2px solid black;
	border-collapse: collapse;
	margin: auto;
}

table {
	width: 450px;
	height: 550px;
	text-aglin : center;
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
	margin: auto;
	text-aglin : center;
}

button:hover {
	background: aqua;
}

</style>
</head>
<body>

	<table>
	<caption><h1>글 상세보기</h1></caption>
		<tr>
			<th>글번호</th>
			<td>${detail.num}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${detail.name}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${detail.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${detail.content}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${detail.date}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${detail.hit}</td>
		</tr>
		<tr>
			<th>파일</th>
			<td><img src="fileUpload/${detail.file}" width="200px"><br>${detail.file}</td>
		</tr>
		<tr>
			<th colspan = "2"><button onclick="location.href='bModify?bNum=${detail.num}'" style='cursor:pointer;'>수정하기</button>
				<button style='cursor:pointer;' onclick ="back()" >뒤로가기</button></th>
			<!-- 버튼태그는 form 안에 있으면 무조건 submit ! -->
		</tr>

	</table>

	
</body>
<script>

	function back() {
		history.go(-1);
	}
</script>
</html>