<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "inputController" Method = "POST">
		<input type = "text" name ="data1"><br/>
		<input type = "text" name ="data2"><br/>
		
		<input type = "submit" value = "제출">
		

	</form>
	첫번째 : <a href="selectData">data 조회 1</a>
	두번째 : <button onclick="selectDB()"> data 조회 !</button>

</body>
<script>
	function selectDB() {
		locataion.href = "selectData";
	}
</script>
</html>