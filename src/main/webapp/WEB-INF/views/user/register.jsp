<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<!--   <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->


  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/resources/smart/js/service/HuskyEZCreator.js" charset="utf-8"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({
           
      changeMonth: true,
      changeYear: true
      
    });
    $( "#datepicker" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
  } );
  </script>
<script>
	$(function() {
		
	})
</script>
<style>
	.box{
		width: 50%;
		margin: 0 auto;
		
	}
	#year{
		width: 30%;
		float: left;
		margin-right: 2%;
	}
	#month{
		width: 30%;
		float: left;
		margin-right: 2%;
	}
	#date{
		width: 30%;
		float: left;
		margin-right: 2%;
	}
	#ac_fail{
		color: red;
	}
	#userId{
		width: 85%;
		float: left;
	}
	#dul{
		width: 15%;
	}
	#ID_div{
		overflow: hidden;
	}
	
</style>
<style>
  #addmin_Modal .modal-header,  #addmin_Modal h4, #addmin_Modal .close {
    background-color: #d9534f;
    color:white !important;
    text-align: center;
    font-size: 30px;
  }
  #addmin_Modal .modal-footer {
    background-color: #f9f9f9;
  }
  </style>

	<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header with-border">
					<h1 class="box-title">회원가입</h1>
				</div>
					<form  id="f1" role="form" method="post" action="register" enctype="multipart/form-data">
						<div class="box-body">
							<label>아이디</label>
							<div class="form-group" id="ID_div">
								
								<input type="text" name="userId" class="form-control" placeholder="아이디 (영소문자 or 숫자 6~20자리)" id="userId"> 
								<input type="button" class="form-control" value="중복체크" id="dul">
							</div>
							 <div class="form-group">
								<label>이름</label>
								<input type="text" name="name" class="form-control" placeholder="이름(한글 2~4자리)" id="name">
							</div>
							<div class="form-group">
								<label>닉네임</label>
								<input type="text" name="nickname" class="form-control" placeholder="닉네임(영소문자 or 숫자 or 한글 1~20자리)" id="nickname">
							</div>
							<div class="form-group">  
								<label>비밀번호</label>
								<input type="password" name="password" class="form-control" placeholder="비밀번호(영소문자 or 숫자 or 특수문자[!@#$%] 8~20자리)" id="password">
							</div> 
							<div class="form-group">  
								<label>비밀번호 확인</label>
								<input type="password" name="password_ck" class="form-control" placeholder="비밀번호 확인" id="password_ck">
							</div> 
							<div class="form-group">
								<label>이메일</label>
								<input type="text" name="email" class="form-control" placeholder="이메일" id="email">
							</div>
							<div class="form-group">
								<label>생년월일</label><br>
								<input type="text" name="birthday" id="datepicker" class="form-control" size="30" placeholder="생년월일">
								<!-- <input type="hidden" name="birthday" value="" id="birthday"> -->
							</div>
							<div class="form-group">
								<label>성별</label>
								<select name="gender" id="gender" class="form-control">
									<option>성별</option>
									<option value="false">남자</option>
									<option value="true">여자</option>
								</select>
							</div>
							<div class="form-group">
								<label>프로필 사진</label>
								<input type="file" name="imageFiles" id="imageFiles" class="form-control">
								<input type="hidden" name="profileImage" id="profileImage" class="form-control">
							</div>
							<div class="form-group">
								<label>휴대전화</label>
								<input type="text" name="phone" class="form-control" placeholder="전화번호 입력 ex) 010-1234-5678" id="phone">
							</div>
							<input type="checkbox" name="admin" id="admin_check" value="true" class="admin"><a href="#" id="cl" >관리자</a>
						<div class="box-footer">
							<button type="submit" class="btn btn-primary" id="addUser">확인</button>
							<button type="reset" class="btn btn-danger" onClick="history.back()">취소</button>
							<!-- <p>테스트<a href="https://www.naver.com/" target="_blank">아니이이이이</a></p>   -->
						</div>
						</div>
					</form>
			</div>
		</div>
	</div>
	
	
	<div class="container">

  <!-- Modal -->
  <div class="modal fade" id="addmin_Modal" role="dialog">
    <div class="modal-dialog">
    	
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4>관리자 전용 페이지 입니다</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-lock"></span> 관리자 비밀번호</label>
              <input type="password" class="form-control" id="admin_pw" value="">
              <input type="hidden" id="ad_pw" value="${ac.adminPw }">
            </div>
            <label id="ac_fail"></label>
            <button id="ac_ok" type="button" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> 확인</button>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
        </div>
      </div>
      
    </div>
  </div> 
</div>
 
<script>
$(document).ready(function(){
	$("input.admin").prop("disabled", true);
  $("#cl").click(function(){
	  $("input:checkbox[id='admin_check']").prop("checked", false);
    $("#addmin_Modal").modal();
    $("#admin_pw").val("");
    $("#ac_fail").text("");
  });
  
  
  $("#ac_ok").click(function() {
			if($("#admin_pw").val() == $("#ad_pw").val()){
				$("input:checkbox[id='admin_check']").prop("checked", true);
				$("#addmin_Modal").modal("hide");
			}else if($("#admin_pw").val() != $("#ad_pw").val()){   
				$("input:checkbox[id='admin_check']").prop("checked", false); 
				$("#ac_fail").text("비밀번호가 틀리셨습니다.");
			}
		
	});
});


$(function() {
	
	
	
	
	
	
	
	$("#f1").submit(function() {
		/* var year = $("#year").val();
		var month = $("#month").val();
		var date = $("#date").val();
		var bir = year+"-"+month+"-"+date;
		$("#birthday").val(bir); */
		
		var pro = $("#imageFiles").val();
		
		if(pro == null || pro == ""){
			
			//기본이미지
			$("#profileImage").val("/profile/s_2545f896-5575-4b8b-9a1f-ba34902a2cf8_5afc60f3c282a.jpg");
			return true;
		}
		
		
		$("#profileImage").val(pro);
		
		return true;
	})
	
	
})
</script>
<script>
	$(function() {
		/* var idck = 0;
		  $("#dul").click(function(){
		       var userId = $("#userId").val();
		       var jsonBody = {userId:userId}
		       $.ajax({
		          url:"${pageContext.request.contextPath}/user/dul",
		          type:"POST",
		          headers:{"Content-Type":"application/json","X-HTTP-Method-Override":"POST"},
		          data:userId,
		          dataType:"text",
		          success:function(data){
		             console.log(data)
		             if(data == "false"){
		                alert("중복된 아이디 입니다.")
		                idck = 0;
		             }else{
		                alert("사용할수 있는 아이디 입니다.")
		                idck = 1;
		             }
		          }
		       })         
		    }) */
		$("#addUser").click(function() {
			var userId = $("#userId").val();
		      var password = $("#password").val();
		      var password_ck = $("#password_ck").val();
		      var name = $("#name").val();
		      var nickname = $("#nickname").val();
		      var phone = $("#phone").val();
		      var birthday = $("#datepicker").val();
		      var gender = $("#gender").val();
		      var email = $("#email").val();
		      var regpass = /^[a-z0-9!@#$%]{8,20}$/i;
		      var regName = /^[가-힣]{2,4}$/;
		      var regId = /^[a-z0-9]{6,20}$/;
		      var regNick = /^[a-z0-9가-힣]{1,20}$/;
		      var jsonBody = {userId:userId, password:password, name:name, phone:phone,birthday:birthday, email:email, nickname:nickname} //photo:photo
		      if(userId == ""){
		         alert("아이디를 입력해주세요")
		         return false;
		      }
		      if(!regId.test(userId)){
			         alert("아이디 양식에 맞지 않습니다.")
			         return false;
			      }
		      if(name == ""){
			         alert("이름을 입력해주세요")
			         return false;
			      }
		      if(!regName.test(name)){
			         alert("이름이 올바르지 않습니다.")
			         return false;
			      }
		      if(nickname == ""){
			         alert("닉네임을 입력해주세요")
			         return false;
			      }
		      if(!regNick.test(nickname)){
			         alert("사용불가능한 닉네임입니다.")
			         return false;
			      }
		      if(password == ""){
		         alert("비밀번호를 입력해주세요")
		         return false;
		      }
		      if(password_ck == ""){
		         alert("비밀번호 확인을 입력해주세요")
		         return false;
		      }
		      if(!regpass.test(password)){
			         alert("비밀번호 양식에 맞지않습니다.")
			         return false;
			      }
		      if(password != password_ck){
		         alert("비밀번호 확인이 일치하지 않습니다.")
		         return false;
		      }
		      if(email == ""){
			         alert("이메일을 입력해주세요")
			         return false;
			      }
		      if(birthday == ""){
			         alert("생년월일을 입력해주세요")
			         return false;
			      }
		      if(gender == null){
			         alert("성별을 입력해주세요")
			         return false;
			      }
		      if(phone == ""){
		         alert("전화번호를 입력해주세요")
		         return false;
		      }
		     
		      
		      
		      
		      
		      /* if(idck == 0){
		         alert("아이디 중복체크를 해주세요")
		         return false;
		      }       */   
		})
	})
</script>
	
	
</section>

<%@ include file="../include/footer.jsp" %> 