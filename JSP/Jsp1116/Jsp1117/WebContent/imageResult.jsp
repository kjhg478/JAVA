<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
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
            margin : auto;
        }
        caption {
        	margin-bottom : 20px;
        }
    </style>
</head>
<body>
	<table>
		
		<tr>
		<% for(int i =0; i<(int)request.getAttribute("num"); i++){ %>
			
			<td><img src="Image/<%= request.getAttribute("background"+i) %>" width="200px" height="250px"/></td>
			
		<% } %>
		
		
		
		
<%-- 		<c:forEach var="background" items="${background1}"> 
				<td><img src="Image/${background}" width="200px" height="250px"/></td>
			</c:forEach> --%>
		</tr>

	</table>
</body>
</html>