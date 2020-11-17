<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
 
 <!-- prefix="c" : 태그를 사용할 때 항상 앞에 c를 붙여준다. -->
 <!-- c를 붙여주지 않아도 문법상 오류는 없지만 c를 사용하는 것이 약속된 형태(core의 약자) -->
 <!-- uri : core라이브러리가 존재하는 위치 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 변수설정 : c:set  -->
	<c:set var="test" value="Hello JSTL!"/>
	
	<h3>c:set 사용 후 => <c:out value="${test}"/></h3>
	
	<!-- c:if 참일때만 실행 -->
	<c:if test="${5<10}">
		<h3>참일 경우에만 c:if안에 있는 내용이 실행</h3>
	</c:if>
	<c:if test="${5>10}">
		<h3>참일 경우에만 c:if안에 있는 내용이 실행</h3>
	</c:if>
	
	<!-- c:choose / c:when / c:otherwise -->
	<!--  			  if		else	 -->
	
	<c:choose>
		<c:when test=$"{10+10 == 30}">
			<h3>참이면 출력, 거짓이면 출력하지 않는다 !</h3>
		</c:when>
		<c:otherwise>
			<h3>10+10 = 20이다 !</h3>
		</c:otherwise>
	</c:choose>
	
	<!-- c: forEach (for문)  -->
	
	<c:forEach var="num" begin="1" end="10" step="2">
		${num} &nbsp;
	</c:forEach>	
</body>
</html>