<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
<!--   <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->



<style>
	.box{
		width: 50%;
		margin: 0 auto;
		
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

	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header with-border">
					<h1 class="box-title">블로그 만들기</h1>
				</div>
					<form  id="f1" role="form" method="post" action="blogRegister">
						<div class="box-body">
							<input type="hidden" name="bUserId" class="form-control" value="${login.userId }">
							<div class="form-group">
								<label>블로그명</label>
								<input type="text" name="blogName" class="form-control" placeholder="블로그명"> 
							</div>
							 <div class="form-group">
								<label>자기소개</label>
								<textarea name="introduction" id="introduction" class="form-control" rows="10" cols="30" placeholder="자기소개" style="resize: none;"></textarea>
							</div>
							<div class="form-group">
								<label>스킨</label>
								<input type="radio" name="skin" value="0" checked="checked">기본스킨
								<input type="radio" name="skin" value="1" disabled="disabled">추가예정
								<input type="radio" name="skin" value="2" disabled="disabled">추가예정
							</div>
						<div class="box-footer">
							<button type="submit" class="btn btn-primary">확인</button>
							<button type="reset" class="btn btn-danger" onClick="history.back()">취소</button>
							<!-- <p>테스트<a href="https://www.naver.com/" target="_blank">아니이이이이</a></p>   -->
						</div>
						</div>
					</form>
			</div>
		</div>
	</div>
	
	
<%@ include file="../include/footer.jsp" %>