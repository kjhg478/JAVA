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
	height: 500px;
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
		<tr>
			<th colspan="1">안녕하세요 <br /> <br /> JH월드의 오신 것을 환영합니다.
			</th>
		</tr>
		<tr>
			<th><a href="Login.jsp"><button style='cursor: pointer;'>로그인</button></a></th>
		</tr>
		<tr>
			<th><a href="LogoutController"><button
						style='cursor: pointer;'>로그아웃</button></a></th>
		</tr>
		<tr>
			<th><a href="MemberViewController"><button
						style='cursor: pointer;'>회원목록 보기</button></a></th>
		</tr>
		<tr>
			<th><a href="MemberModify.jsp"><button
						style='cursor: pointer;'>회원정보 수정</button></a></th>
		</tr>
		<tr>
			<th><a href="Write.jsp"><button style='cursor: pointer;'>게시글
						작성</button></a></th>
		</tr>
		<tr>
			<th><a href="BoardListController"><button style='cursor: pointer;'>게시글
						목록</button></a></th>
		</tr>
		<tr>
			<th><a href="MemberDel.jsp"><button style='cursor: pointer;'>회원정보
						삭제</button></a></th>
		</tr>

	</table>
</body>
</html>