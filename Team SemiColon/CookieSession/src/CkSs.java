/*1. 세션(Session) 사용 예제



- 세션(Session) 설정 (로그인 성공시에 로그인 아이디를 세션에 저장한다.)



<%@ page language ="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>



<% request.setCharacterEncoding("euc-kr");%>



<%

String id = request.getParameter("id");                        // request에서 id 파라미터를 가져온다

String passwd = request.getparameter("passwd");      // request에서 passwd 파라미터를 가져온다.



--- 로그인 처리 ...   로그인 성공시 check 는 TRUE --



if(check){                                                        // 로그인 성공시



	session.setAttribute("id", id);                 // 세션에 "id" 이름으로 id 등록

	response.sendRedirect("main.jsp");               // 로그인 성공 메인페이지 이동



}else{%>                                                        // 로그인 실패

<script>

alert("로그인 실패");

history.go(-1);                                    // 이전 페이지로 이동

</script>

<%}%>



- 세션(Session) 가져오기 (세션에서 아이디를 가져와 로그인 상태를 인증하고, 값이 없을 경우 로그인 페이지로 넘긴다.)



<%@ page language ="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>



<% request.setCharacterEncoding("euc-kr");%>



<%



String id = "";



try{

	id = (String)session.getAttribute("id");            // request에서 id 파라미터를 가져온다



	if(id==null||id.equals(""){                            // id가 Null 이거나 없을 경우

		response.sendRedirect("loginform.jsp");    // 로그인 페이지로 리다이렉트 한다.

	}

	<%}%>



	- 세션(Session) 제거하기 (로그아웃 시 현재의 세션 정보를 제거한다.)



	<%@ page language ="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>



	<% session.invalidate(); %>                         // 세션 정보 제거



	<script>

	alert("로그아웃 되었습니다.");

	location.href="logout.jsp";                                    // 로그아웃 페이지로 이동

	</script>


	-----------------------------------------------------------------------------------------------------------------------
	2. 쿠키 사용 예제



	(1) 쿠키 읽어서 가져오기    (자동 로그인 처리)



	<%@ page language ="java" contentType ="text/html;charset=EUC-KR" pageEncoding="EUC-KR"%>



	<%

	String id = "";



	try{

		Cookie[] cookies = request.getCookies();                 // 요청에서 쿠키를 가져온다.



		if(cookies!=null){                                                    // 쿠키가 Null이 아닐때,



			for(int i=0; i<cookies.length; i++){                        // 쿠키를 반복문으로 돌린다.

				if(cookies[i].getName().equals("id")){            // 쿠키의 이름이 id 일때

					id=cookies[i].getValue();                        // 해당 쿠키의 값을 id 변수에 저장한다.

				}

			}

			if(id.equals("")){                                            // 쿠키에서 이름 id를 찾지 못했을때

				response.sendRedirect("loginForm.jsp");    // loginForm 으로 리다이렉트 한다.

			}



		}else{                                                                // 요청에서 쿠키가 없을때

			response.sendRedirect("loginForm.jsp");    // loginForm 으로 리다이렉트 한다.

		}

	}catch(Exception e){}

	%>



	(2) 쿠키 저장하기    (로그인 정보 등록)



	<%@ page language ="java" contentType ="text/html;charset=EUC-KR" pageEncoding="EUC-KR"%>

	<% request.setCharacterEncoding("euc-kr"); %>



	<%

	String id = request.getParameter("id");                        // 요청에서 id 값을 가져온다.

	String passwd = request.getParameter("passwd");      // 요청에서 passwd 값을 가져온다.



	.....                                                // id 와 passwd 로 로그인 을 확인한다.



	if(check == 1){                                // 로그인이 성공일때,



		Cookie cookie = new Cookie("id", id);        // id 라는 이름과 request의 id 값으로 쿠키 생성

		cookie.setMaxAge(20*60);                        // 쿠키의 유효시간을 20분으로 설정

		response.addCookie(cookie);                    // 쿠키를 응답에 추가

		response.sendRedirect("cookieMain.jsp");    // cookieMain 으로 리다이렉트



	}else {}



	%>



	(3) 쿠키 삭제하기    (로그아웃)



	<%@ page language ="java" contentType ="text/html;charset=EUC-KR" pageEncoding="EUC-KR"%>



	<%

	Cookie[] cookies = request.getCookies();                    // 요청에서 쿠키를 가져온다.



	if(cookies!=null){                                            // 쿠키가 Null이 아니라면



		for(int i=0; i<cookies.length; i++){                // 쿠키를 반복문으로 돌린다.



			if(cookies[i].getName().equals("id")){        // 쿠키의 이름이 id 일때

				cookies[i].setMaxAge(0);                    // 쿠키의 유효시간을 0 으로 셋팅한다.

				response.addCookie(cookies[i]);        // 수정한 쿠키를 응답에 추가(수정) 한다.

			}

		}

	}

	%>*/