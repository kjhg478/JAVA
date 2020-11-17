<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        table,tr,td,th{
            border : 1px solid;
            text-align: center;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
	<form action = "Login1" Method = "POST">
	<table>
		<caption>환영합니다 Developer</caption>
		<tr>
			<td>아이디 : <%=request.getParameter("sId") %> </td>
		</tr>
		<tr>
			<td>비밀번호 : <%=request.getParameter("sPw") %> </td>
		</tr>
		<tr>
			<td>주소 : <% %>></td>
		</tr>
	</table>
	</form>
</body>
</html>