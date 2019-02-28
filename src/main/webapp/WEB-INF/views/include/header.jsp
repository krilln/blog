<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<style>
	body{
		margin: 0;
		padding: 0; 
	}

	header{
		width: 1920px;
		height: 200px; 
	}
	#header{
		width: 80%;  
	}
	#header #header_ul{
		overflow: hidden;
		width: 30%;  
		position: absolute; 
		right:10px;
		top:10px; 
		margin-top: 0px;
		margin-bottom: 0px;
	}
	#header #header_ul li{
		list-style: none;
		float: left;
		padding-left:7px;
		font-size: 11px;
	}
	#header #header_ul li a{
		text-decoration: none;
		color: black;
	}
	#header #header_ul li .bar{
		color: #707070;  
	}
	#header #header_ul li #loginBtn{
		background-color: white;   
		border: 0.5px solid rgba(189, 189, 189, 0.7);
		padding: 2px;
		padding-top: 2px;
		padding-bottom: 0px;
	}
	#header #header_ul li #loginBtn a{
		text-decoration: none;
		color: #707070; 
		font-weight: bold; 
	}
</style>
  <style>
  .modal-header, h4, .close {
    background-color: #5cb85c;
    color:white !important;
    text-align: center;
    font-size: 30px;
  }
  .modal-footer {
    background-color: #f9f9f9;
  }
  .content{
  	width: 70%;
  	margin:  0 auto;
  	overflow: hidden;
  }
  </style>
</head>
<body>
 <header>
 	<div id="header">
 		<ul id="header_ul">
 			<li><a href="#">내 블로그</a>  <span class="bar">ㅣ</span></li>
 			<li><a href="#">이웃블로그</a>  <span class="bar">ㅣ</span></li>
 			<li><a href="#" id="blog_home">블로그 홈</a>  <span class="bar">ㅣ</span></li>
 			<li>
 				<div id="loginBtn">
 					<c:if test="${login != null }">
                    	<%-- ${dest.nickname }hh${dest.nickname } --%><a href="${pageContext.request.contextPath }/login/logout" id="myBtn">로그아웃</a>
                    </c:if>
                     <c:if test="${login == null }">
                    	<a href="#" id="myBtn">로그인</a>
                    </c:if>
 					<!-- <a href="#" id="myBtn">로그인</a>   -->
 				</div>
 			</li>
 		</ul>
 	</div>
 </header>
 
 <div class="container">

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
          <h4><span class="glyphicon glyphicon-lock"></span> 로그인</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" action="${pageContext.request.contextPath }/login/loginPost" method="post">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> 아이디</label>
              <input type="text" class="form-control" name="userId" id="usrname" placeholder="아이디">
            </div>
            <div class="form-group"> 
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 비밀번호</label>
              <input type="text" class="form-control" name="password" id="psw" placeholder="비밀번호">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>아이디 저장</label>
            </div>
              <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> 로그인</button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 취소</button>
          <p>회원이 아닌가요? <a href="#" id="go_register">회원 가입</a></p>
          <p>비밀번호를 잊었나요? <a href="#">비밀번호 찾기</a></p>
        </div>
      </div>
      
    </div>
  </div> 
</div>
 
<script>
$(document).ready(function(){
  $("#myBtn").click(function(){
    $("#myModal").modal();
  });
  $("#go_register").click(function() {
		location.href = "${pageContext.request.contextPath }/user/register";
	})
	$("#blog_home").click(function() {
		location.href = "${pageContext.request.contextPath }/blogHome/list";
	})
});
</script>
