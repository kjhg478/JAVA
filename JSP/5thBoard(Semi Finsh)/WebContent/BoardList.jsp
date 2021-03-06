<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>

<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>ICIA D CALSS BOARD</title>
<meta content="" name="descriptison">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/table.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: WeBuild - v2.1.0
  * Template URL: https://bootstrapmade.com/free-bootstrap-coming-soon-template-countdwon/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
<style type="text/css">
select {
	-webkit-appearance: none; /* 네이티브 외형 감추기 */
	-moz-appearance: none;
	appearance: none;
/* 	background: url(이미지 경로) no-repeat 95% 50%; */ /* 화살표 모양의 이미지 */
} /* IE 10, 11의 네이티브 화살표 숨기기 */
select::-ms-expand {
	display: none;
}

select {
	width: 150px; /* 원하는 너비설정 */
	padding: .3em .3em; /* 여백으로 높이 설정 */
	font-family: inherit; /* 폰트 상속 */

	background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  	background: linear-gradient(to right, #25c481, #25b7c4);
/*  	background:		
		url(https://farm1.staticflickr.com/379/19928272501_4ef877c265_t.jpg)
		no-repeat 90% 40%;  */ /* 네이티브 화살표 대체 */
	background-color: -webkit-linear-gradient(left, #25c481, #25b7c4);
 	background-color: linear-gradient(to right, #25c481, #25b7c4);
	border: 1px solid #999;
	border-radius: 0px; /* iOS 둥근모서리 제거 */
	-webkit-appearance: none; /* 네이티브 외형 감추기 */
	-moz-appearance: none;
	appearance: none;
	padding: 7px 15px;
  	text-align: center;
  	font-weight: 1000;
  	font-size: 24px;
  	color: #000000;
  	text-transform: uppercase;

}

th{
	color: #000000;
	font-weight: 1000;
}

</style>
</head>
<body>
	<!-- ======= Header ======= -->
	<header id="header" style="padding: auto;">
		<div class="container-fluid">

			<div class="logo float-left">
				<h1 class="text-light">
					<a href="Main.jsp"><span
						style="font-size: 35px; font-weight: bold;">ICIA</span></a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>

			<div class="contact-link float-right">
				<a href="memberLogout?id=${id}" class="scrollto"
					style="font-size: 35px; font-weight: bold;">Logout</a>
			</div>

		</div>
	</header>
	<!-- End #header -->

	<!-- ======= Hero Section ======= -->
	<section id="hero">
		<div class="hero-container" style="padding: 0 50px;">
			<h1>ICIA D CLASS BOARD</h1>
			<br/><br/>
			<section>
			<div class="tbl-header" >
				<table>
					<thead>
						<tr>
							<th>
						
							<form action = "BoardCategoryController">
							<select name="subject" id = "selection" onchange="this.form.submit(value)" > <!-- style="vertical-align:middle; margin:auto; text-align-last:center;" -->
							<option value="all" selected >전체</option>
					
							<option value="Notice">공지사항</option>
							<option value="PartBoard">조별게시판</option>
							<option value="FreeBoard">자유게시판</option>
							<option value="QNABoard" >건의게시판</option>
						
							</select>
							</form>
					
							</th>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>
							<form action = "BoardHitController">
							<select name="hit" id = "many" onchange="this.form.submit(value)" >
							<option value="all2" selected >최신순</option>
							<option value="max">조회순</option>
							</select>
							</form>
							</th>
							<c:if test="${Level eq 'M' }">
							<th>삭제</th>
							</c:if>
						</tr>
					</thead>
				</table>
			</div>
			<div class="tbl-content">
				<table>
					<tbody>
						<c:forEach items="${boardList }" var="list">
							<c:if test = "${list.subject eq 'Notice' }">
							<tr>
								<td style = "font-weight:700; "  >${list.subject }</td>
								<td >${list.num}</td>
								<td style = "font-weight:700; "><a href="writeDetail?num=${list.num}&level=${Level}" style="color:black;">${list.title }</a></td>
								<td >${list.nick}</td>
								<td >${list.date}</td>
								<td >${list.hit}</td>
								<c:if test="${Level eq 'M' }">
								<td style = ><a href="writeDelete?num=${list.num}&level=${Level}" style="color:black;">삭제</a></td>
								</c:if>
							</tr>
							</c:if>
						</c:forEach>
						<!-- 				<tr class='even'>
					<td colspan="2.5"><a href="#">메인페이지</a></td>
					<td colspan="2.5"><a href="#inexistent-id">글쓰기</a></td>
				</tr> -->
						<c:forEach items="${boardList }" var="list">
							<c:if test = "${list.subject ne 'Notice' }">
							<tr>
								<td>${list.subject }</td>
								<td>${list.num}</td>
								<td><a href="writeDetail?num=${list.num}&level=${Level}" style="color:black;">${list.title }</a></td>
								<td>${list.nick}</td>
								<td>${list.date}</td>
								<td>${list.hit}</td>
								<c:if test="${Level eq 'M' }">
								<td><a href="writeDelete?num=${list.num}&level=${Level}" style="color:black;">삭제</a></td>
								</c:if>
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</section>	
			<form action="searchKeyword" class="php-email-form" method = "GET" >
			<br/>
			<table>
			<tr>
			<th colspan = "3">
			<!-- 페이징 처리 -->

			<!-- 현재 페이지 1페이지 이거나 1페이지보다 작은 경우 -->
			<c:if test="${paging.page<=1}">[이전]&nbsp; &nbsp; &nbsp;</c:if>

			<!-- 현재 페이지가 1페이지 보다 클 경우 -->
			<c:if test="${paging.page>1}">
				<a href="writeList?page=${paging.page-1}">[이전]</a>&nbsp; &nbsp; &nbsp;
			</c:if>

			<!-- 현재 페이지 표시 -->
			<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
				var="i" step="1">
				<c:choose>

					<c:when test="${i eq paging.page}">
				${i}
			</c:when>


					<c:otherwise>
						<a href="writeList?page=${i}">${i}</a>

					</c:otherwise>

				</c:choose>

			</c:forEach>

			<!-- 현재 페이지가 끝페이지 이거나 끝페이지보다 큰 경우 -->
			<c:if test="${paging.page >= paging.maxPage}">&nbsp; &nbsp; &nbsp;[다음]</c:if>

			<!-- 현재 페이지가 끝페이지보다 작은 경우 -->
			<c:if test="${paging.page < paging.maxPage}">
			&nbsp; &nbsp; &nbsp;<a href="writeList?page=${paging.page+1}">[다음]</a> 
			</c:if>
			</th>

		</tr>

		<tr>
			<th colspan="3" align="center" style="padding:10px;">
			<select style="width: 150px; height: 42px; padding:10px; font-size:17px;">
				<option value="title">제목</option>
				
			</select>
			<input type="text" name="search" style="height: 42px;" required>
			<button type="submit" style="width: 150px; height: 42px; padding:11px; font-size:17px;">검색</button></th>	
			
		</tr>


	</table>
	</form>
	
			<br/>
			<form action="forms/notify.php" method="post" role="form"
				class="php-email-form">
				<div class="text-center" style="text-align: center;">
					<input type="button" onclick="location.href='Main.jsp'"
						value="메인페이지" style="width: 150px; height: 42px;"> 
						&nbsp; &nbsp; &nbsp;
						<input type="button" onclick="location.href='BoardWriteForm.jsp'"
						value="글쓰기" style="width: 150px; height: 42px;">

				</div>
			</form>
	</div>
</section>
</body>

	<!-- End Hero -->
<script src="https://ajax.googleapis.com/ajax/libs/d3js/6.2.0/d3.min.js"></script>
<script type="text/javascript">


</script>
</html>