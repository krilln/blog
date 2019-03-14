<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 
<style>
	.box{
		width: 70%;
		margin: 0 auto;
		
	}
	.box-body{ 
		overflow: hidden;
	}
	#cate_title_div{
		border: 2px solid #D5D5D5;
		border-radius: 5px;
		padding-top: 30px;
		padding-bottom: 30px;
	}
	#cate_title_div li{
		list-style: none;
	}
	#category{
		width: 70%;
	}
	#title{
		width: 80%;
	}
	#subject{
		width: 20%;
	}
	#writingOpen{
		margin-left: 1.5%;
	}
	
</style>
	<section class="content">
	<div class="row">
	<div class="col-sm-3">
	<h3 class="box-title">카테고리 목록</h3>
		<div class="form-group" id="cate_title_div">
		
								<ul>
									<c:forEach var="cate_c" items="${cate_list_c}">
										<li>- ${cate_c.category}</li>
									</c:forEach>
								</ul>
							</div>
	</div>
		<div class="col-sm-9">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">카테고리 추가</h3>
				</div>
					<form  id="f1" role="form" method="post" action="categoryRegister">
						<div class="box-body">
						<input type="hidden" name="userId" id="userId" class="form-control" value="${login.userId }">
						<div class="form-group">
						<label>카테고리명</label>
						<input type="text" name="category" id="category" class="form-control" placeholder="카테고리명">
						</div>
							
						<div class="form-group">
						<label>주제</label>
								<select name="subject" id="subject" class="form-control">
									<c:forEach var="sub_c" items="${sub_list_c}">
										<option value="${sub_c.subject}">${sub_c.subject}</option>
									</c:forEach>
									
								</select>
						</div>
						<div class="form-group">
								<label>공개설정</label>
								<input type="radio" name=categoryOpen id="writingOpen" value="1" checked="checked"> 공개
								<input type="radio" name=categoryOpen id="writingOpen" value="0"> 비공개
						</div>
						<div class="form-group">
								<label>대표카테고리</label>
								<input type="radio" name=representCategory id="writingOpen" value="1"> 설정
								<input type="radio" name=representCategory id="writingOpen" value="0" checked="checked"> 비설정
						</div>
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
	</section>
<%@ include file="../include/footer.jsp" %> 