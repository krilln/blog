<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		<div class="container-fluid">
	  <h1>Hello World!</h1>
	  <p>Resize the browser window to see the effect.</p>
	  <p>The columns will automatically stack on top of each other when the screen is less than 768px wide.</p>
	  <div class="row">
	    <div class="col-sm-2" style="background-color:lavender;">.col-sm-2 
	    	<div id="profile">
	    		<div id="pro_img">
	    			<!-- 프로필 이미지 -->
	    		</div>
	    		<div id="ID">
	    			<!-- 닉네임&아이디 -->
	    		</div>
	    		<div id="intro">
	    			<!-- 자기소개 -->
	    		</div>
	    	</div>
	    	<div id="category">
	    		<!-- 카테고리 -->
	    	</div>
	    </div>
	    <div class="col-sm-10" style="background-color:lavenderblush;">.col-sm-10
	    	<div id="board">
	    		<!-- 게시판 -->
	    	</div>
	    </div>
	  </div>
		</div>
</body>
</html>