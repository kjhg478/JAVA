<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- [Ctrl] + [Shift] + [/] : 주석처리  -->
    <!-- 
    	(1) 지시어 (Directive)
    		: <%-- <%@ %> --%> 로 구성되어 있는 코드 !
    		1) Page
    		2) Include
    		3) taglib
    		
    	(2) page 지시어
    		1) language
    		2) extends
    		3) import
    		4) session
    		5) errorPage
    		6) contentType
    		7) pageEncoding
    		
    	(3) include 지시어
    	
    	(4) taglib 지시어
    
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "Header.jsp" %>
	<hr/>
	<h1>여기는 body 부분입니다 ! </h1>
	<hr/>
	<%@ include file = "Footer.jsp" %>
</body>
</html>