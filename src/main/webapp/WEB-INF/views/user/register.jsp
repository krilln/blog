<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 

  
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<!--   <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->

  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
							<div class="form-group">
								<label>아이디</label>
								<input type="text" name="userId" class="form-control" placeholder="아이디"> 
							</div>
							 <div class="form-group">
								<label>이름</label>
								<input type="text" name="name" class="form-control" placeholder="이름">
							</div>
							<div class="form-group">
								<label>닉네임</label>
								<input type="text" name="nickname" class="form-control" placeholder="닉네임">
							</div>
							<div class="form-group">  
								<label>비밀번호</label>
								<input type="password" name="password" class="form-control" placeholder="비밀번호">
							</div> 
							<div class="form-group">
								<label>이메일</label>
								<input type="text" name="email" class="form-control" placeholder="이메일">
							</div>
							<div class="form-group">
								<label>생년월일</label><br>
								<!-- <input type="text" id="year" placeholder="년(4자)" class="form-control">
								<select id="month" class="form-control">
									<option>월</option>
									<option value="01">1</option>
									<option value="02">2</option>
									<option value="03">3</option>
									<option value="04">4</option>
									<option value="05">5</option>
									<option value="06">6</option>
									<option value="07">7</option>
									<option value="08">8</option>
									<option value="09">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
								</select>
								<input type="text" id="date" placeholder="일" class="form-control"> -->
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
								<input type="text" name="phone" class="form-control" placeholder="전화번호 입력 ex) 010-1234-5678">
							</div>
							<input type="checkbox" name="admin" id="admin_check" value="true" class="admin"><a href="#" id="cl" >관리자</a>
						</div>   
						<div class="box-footer">
							<button type="submit" class="btn btn-primary">확인</button>
							<button type="reset" class="btn btn-danger" onClick="history.back()">취소</button>
							<!-- <p>테스트<a href="https://www.naver.com/" target="_blank">아니이이이이</a></p>   -->
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
			$("#profileImage").val("/profile/s_91b189d2-96c8-4a9e-91e5-344eecc3582e_5afc60f3c282a.jpg");
			return true;
		}
		
		
		$("#profileImage").val(pro);
		
		return true;
	})
	
	
})
</script>
	
	
</section>

<%@ include file="../include/footer.jsp" %> 