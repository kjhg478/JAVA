<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td, th {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 10px;
		text-align: center;
	}
	table {
		width: 300px
	}
</style>
</head>
<body>
	<form action="inputdb" method="GET">
	<table>
		<caption>inputDB</caption>
		
		<tr>
			<td>data1</td>
			<td><input type="text" name="data1"></td>
		</tr>
		<tr>
			<td>data2</td>
			<td><input type="text" name="data2"></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="제출"> 
			</td>
		</tr>
	</table>
	</form>
	첫번째 : <a href="selectData">data 조회1</a>
	두번째 : <button onclick="selectDB()">data 조회2</button>
</body>
<script>
	function selectDB(){
		location.href="selectData";
	}
</script>
</html>








