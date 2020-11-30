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
	width: 480px;
	height: 290px;
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
		<form action="WriteController" name="WriteForm" method="POST"
			enctype="multipart/form-data">
			<caption>
				<h1>게시글 작성하기</h1>
			</caption>
		<tr>
			<th>제목</th>
			<td><input type="text" name="bTitle" size="50"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="bName" size="50"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="Password" name="bPass" size="50"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="25" cols="52" name="bContent"></textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<td><input type="file" name="bFile"></td>
		</tr>
		<tr>
		<tr style="text-align: center;">
			<td colspan="2"><button onclick="bwrite()"
					style='cursor: pointer;'>글작성</button>
		</form>
				<button onclick="location.href ='BoardListController'"
					style='cursor: pointer;'>목록보기</button>
		</tr>
	</table>
</body>
<script>
	function bwrite() {
		WriteForm.submit();
	}
	/* 	function boardList() {
	 location.href = boardListController();
	 }
	 function pageList() {
	 location.href = pageListController();
	 }
	 */
</script>












</html>