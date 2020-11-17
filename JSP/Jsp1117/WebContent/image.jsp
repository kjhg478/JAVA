<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>바다</title>
    <style>
        table,tr,td,th{
            border : 1px solid;
            text-align: center;
            border-collapse: collapse;
            margin : auto;
        }
        caption {
        	margin-bottom : 20px;
        }
    </style>
</head>
<body>
	<form action = "image" Method = "POST">
	<table>
	<caption>좋아하는 색감의 바다를 선택해라</caption>

		<tr>
			<br/>
			<td><img src="Image/바다1.png" width ="300px" height ="300"/></td>
			<td><img src="Image/바다2.jpg" width ="300px" height ="300"/></td>
			<td><img src="Image/바다3.jpg" width ="300px" height ="300"/></td>
		</tr>
		<tr>
			<td><input type ="checkbox" name = "a1" value="바다1.png">1번</td>
			<td><input type ="checkbox" name = "a1" value="바다2.jpg">2번</td>
			<td><input type ="checkbox" name = "a1" value="바다3.jpg">3번</td>
		</tr>
		<tr>
			<td><input type ="submit" value = "선택"></td>
		</tr>
	</table>
	</form>
</body>
</html>