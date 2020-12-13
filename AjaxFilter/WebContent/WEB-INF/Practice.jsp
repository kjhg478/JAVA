<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,tr,td{
border: 1px solid black;
border-collapse : collapse;
margin: auto;
text-align: center;
}
</style>
</head>

<body>
<div id="change">
   <table>
   <tr> <td>아이디를 입력하세요</td>  <td> <input type="text" id="id" name="id"> </td> </tr>
   <tr> <td colspan="2"><span id="result"></span> </td> </tr>
   <tr> <td colspan="2"> <button id="check">중복 체크</button></td> </tr> 
   </table>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
   $("#check").click(function (){
   var userid = $("#id").val();
   
   $.ajax({
      data : {id : userid},
        url : "CheckId",
        type: "post",
        dataType:"json",
        success : function (data) {
         if (data[0]==userid) {
            
             var out = "";
              out+= "<div>";
              out+= "<table>";
              out+= "<tr>";
              out+= "<td> 이름 : "+data[0]+"</td>";
              out+= "</tr>";
              out+= "<tr>";
              out+= "<td> 성별 : "+data[1]+"</td>";
              out+= "</tr>";
              out+= "<tr>";
              out+= "<td> 비밀번호 : "+data[2]+"</td>";
              out+= "</tr>";
              out+= "</table>";
               out+= "</div>";
             document.getElementById("change").innerHTML = out;
             
         }else{
            $("#result").css('color','red');
            $("#result").html(userid+" 이(가) 이미 있습니다.");
         }
        },
        error : function (data) {
            alert("데이터를 불러올수없습니다.");
        }
        
    });
   
   
});
   
   function getInfo(data){
      
   }


</script>
</html>