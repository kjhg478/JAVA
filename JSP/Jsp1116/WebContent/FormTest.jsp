<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
    
    <%
    	String sName = request.getParameter("sName");
    	String sid = request.getParameter("sid");
    	System.out.println("sName : " + sName);
    	System.out.println("sid : " + sid);
    	
    	//if(sid.equals("hoonzzang")) {
    		//sName = "훈짱";
    	//}else {
    		//sName = "훈짱아님";
    	//}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>