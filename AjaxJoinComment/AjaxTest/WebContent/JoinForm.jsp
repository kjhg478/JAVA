<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="ko">
    <head>

        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>JoinForm</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic" rel="stylesheet" type="text/css" />
        <!-- Third party plugin CSS-->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <link href="css/design.css" rel="stylesheet" />
    </head>
    <body id="page-top">
<table>
  <thead>
    <tr>
      <th colspan = 3 style = "text-align : center;">Join</th>
    </tr>
  </thead>
 </table>
 

  				 <form name= "Join" action="memberJoin" method="POST">
				<table>
					<tr>
						<th>ID</th>
						<td><input type="text" name="id" maxlength="20" required autocomplete="off" id="userid" onkeyup = "changeid()" ></td>
						<td><input type="button" id="idcheck" value="Duplicate Check" required></td>

					</tr>

					<tr>
						<th>Password</th>
						<td><input type="password" name="password" id="userPw"
							onchange="check1()" maxlength="15" required></td>
					</tr>

					<tr>
						<th>Password Check</th>
						<td><input type="password" name="checkPw" id="checkPw"
							onchange="check1()" maxlength="15" required></td>
						<td><h4 id="msg"></h4></td>
					</tr>
					<tr>
						<th>Name</th>
						<td><input type="text" name="name" maxlength="6" autocomplete="off" required>
									</td>
					</tr>

					<tr>
						<th>TH</th>
						<td><select name="team" required>
								<option value="">TH</option>
								<option value="01">1</option>
								<option value="02">2</option>
								<option value="03">3</option>
								<option value="04">4</option>
								<option value="05">5</option>
								<option value="06">6</option>
								<option value="07">7</option>
						</select></td>
					</tr>

					
					<tr>
						<td colspan="3" style="text-align: center;">
						<button type="button" onclick="checkidpw()">Join</button></td>
					</tr>
				</table>
				</form>


</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">  

	let checkid = false;
	let checkpw = false;


   	$(document).ready(function(){
   		$('#idcheck').click(function click() {
   			console.log("실행");
   			var userid = $('#userid').val();
   			console.log(userid);
   			if(userid==0){
   	            alert('Please Duplicate Check !');
   	            return false;
   			}
   			
   			$.ajax({
   				async:true,
   				data:{id : userid},
   				url:"IdCheck",
   				type:'POST',
   				dataType:"json",

   				success : function(data) {
   					console.log(data.cnt)
   					if (data.cnt > 0) {
   						alert("ID exists");
   						checkid = false;
   						console.log(checkid);
   					} else {
   						alert("ID Possible");
   						checkid = true;
   						console.log(checkid);

   					}
   				},
   				error : function(data) {
   					alert("데이터를 x")
   				}

   			});
   			
   		});
   	});
var pw1;
var pw2;
 
function check1() {
/* 		var pw = document.getElementById('userPw').value;
    var SC = ["!","@","#","$","%"];
    var check_SC = 0; */
	pw1 = document.getElementById("userPw").value;
	pw2 = document.getElementById("checkPw").value;
    
    if(pw1.length < 6 || pw1.length > 16) {
        window.alert('Please enter a password of at least 6 characters and not more than 16 characters.');
        document.getElementById('pw1').value='';
    }

	var msg = document.getElementById("msg");
		if(pw1==pw2) {
			msg.innerHTML = "Possible Password";
			checkpw = true;
			console.log(checkpw);

		}else {
			msg.innerHTML = "Impossible Password";
			checkpw = false;
			console.log(checkpw);


		}

}
function checkidpw() {
	if(!checkid) {	
		alert("아이디 중복체크를 해주세요");
	}else if(!checkpw) {
		alert("비밀번호를 확인해주세요");
	}else {
		alert("회원가입 성공");
		Join.submit();
	}
}	
function changeid() {
	if(checkid) {
		alert("아이디 중복체크를 해주세요");
	}
}



</script>	

</html>
