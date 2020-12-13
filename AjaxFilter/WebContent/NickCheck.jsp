<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#nickcheck').click(function click() {
			console.log("실행");
			var userid = $('#nick').val();
			console.log(userid);

			$.ajax({
				data : {
					nick : userid
				},
				url : "nickCheck",
				type : 'POST',
				dataType : "json",

				success : function(data) {
					var msg = document.getElementById("msg");
					console.log(data.nick)
					if (data.nick != null) {
						msg.style.color = "red";
						msg.innerHTML = "닉네임 중복입니다.";
						location.href = "Main.jsp?nick=" + encodeURI(userid);

					} else {
						msg.style.color = "blue";
						msg.innerHTML = "닉네임 사용 가능입니다.";
					}
				},
				error : function(data) {
					alert("데이터 없다")
				}

			});

		});
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<input type="text" name="nick" id="nick">
		<button type="button" id="nickcheck">체크</button>
		<h4 id="msg"></h4>


</body>

</html>