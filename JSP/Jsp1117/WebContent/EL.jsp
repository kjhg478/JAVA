<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
	[1] EL(Express Language)
	<%=%> 대신에 ${} 를 사용 !!
	TEST 변수를 사용 =? -> ${TEST}  
	
	Param 객체 사용 !
	ParamValues 사용 !
-->

	<form action = "eLTest.jsp">
		<fieldset>
			<legend>EL 표현식</legend>
			<input type = "text" name = "eLname">
			<input type = "submit" value = "전송">
		</fieldset>
	
	</form>
</body>
</html>