<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
a{
text-decoration: none;
}
li{
font-size: 30px;
}

</style>
</head>
<body>
<h1><a href="#">Ajax Practice</a></h1>
	<nav>
		<ol id = list><!-- #은 북마크로 활용하지만 hashbang (#!) 이 함수는 해쉬함수라는 프로그래머들끼리의 약속 -->																	
<!-- 		<a href="#!Java.jsp" onclick = "print('Java.jsp')"><li> JAVA </li></a>
			<a href="#!C++.jsp" onclick = "print('C++.jsp')"><li> C++ </li></a>
			<a href="#!Python.jsp" onclick = "print('Python.jsp')"><li> Python </li></a>
			<a href="#!Go.jsp" onclick = "print('Go.jsp')"><li> GO </li></a> -->
		</ol>
	</nav>
	
	<div id="here">
	</div>
	<div id="end">
	감사합니다!
	</div>

</body>
<!-- "" 안에 문자 쓸 때는 '' 쓰면 됨 기본적으로 문자는 ""  -->
<script>
function print(language) {
	let lang = language;
	fetch(lang).then((response)=>{
		response.text().then((text)=>{
			document.querySelector('#here').innerHTML = text;
		})
	})	
	
}
console.log(location.hash);
if(location.hash) {
	print(location.hash.substr(2));
}else {
	print('index.jsp');
}
/* <a href="#!Java.jsp" onclick = "print('Java.jsp')"><li> JAVA </li></a> */
fetch('List.jsp').then((response)=>{
	response.text().then((text)=>{
		let tag = text.split(',');
		let listArr = "";
		for(let i in tag) {
			console.log(tag);
			listArr += '<a href=\"#!'+tag[i]+'.jsp\" onclick = \"print(\''+tag[i]+'.jsp\')\"><li> '+tag[i]+' </li></a>';
		}
		document.querySelector('#list').innerHTML = listArr;
	})
})


</script>
</html>