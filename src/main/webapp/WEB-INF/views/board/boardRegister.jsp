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
		overflow: hidden;
	}
	#category{
		width: 20%;
		float: left;
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
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/smart/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	<section class="content">
	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header with-border">
					<h1 class="box-title">글쓰기</h1>
				</div>
					<form  id="f1" role="form" method="post" action="boardRegister" enctype="multipart/form-data">
						<div class="box-body">
						<input type="hidden" name="userId" id="userId" class="form-control" value="${login.userId }">
						<div class="form-group" id="cate_title_div">
								<select name="categoryNo" id="category" class="form-control">
									<option>카테고리</option>
									<c:forEach var="cate" items="${cate_list}">
										<option value="${cate.categoryNo}">${cate.category}</option>
									</c:forEach>
								</select>
								<input type="text" name="title" id="title" class="form-control" placeholder="제목">
							</div>
							<div class="form-group">
								<textarea name="content" id="content" rows="18" cols="129"></textarea>
								<!-- <input type="hidden" name="content" id="content" class="form-control" value=""> -->
							</div>
							<script type="text/javascript">

								var oEditors = [];
								
								nhn.husky.EZCreator.createInIFrame({
								
								    oAppRef: oEditors,
								
								    elPlaceHolder: "content",
								
								    sSkinURI: "${pageContext.request.contextPath }/resources/smart/SmartEditor2Skin.html",
								
								    fCreator: "createSEditor2"
								
								});
								
								</script>
						</div> 
						<div class="form-group">
								<input type="file" name="imageFiles" id="imageFiles" class="form-control" multiple="multiple">
								<input type="hidden" name="file" id="file" class="form-control">
						</div>  
						<div class="form-group">
								<select name="subject" id="subject" class="form-control">
									<c:forEach var="sub" items="${sub_list}">
										<option value="${sub.subject}">${sub.subject}</option>
									</c:forEach>
									
								</select>
						</div>
						<div class="form-group">
								<input type="radio" name=writingOpen id="writingOpen" value="0" checked="checked"> 전체공개
								<input type="radio" name=writingOpen id="writingOpen" value="1"> 이웃공개
								<input type="radio" name=writingOpen id="writingOpen" value="2"> 서로이웃공개
								<input type="radio" name=writingOpen id="writingOpen" value="3"> 비공개
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
	<script>
		 $(function() {
			$("#f1").submit(function() {
				oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			})
		})
	</script>
<%@ include file="../include/footer.jsp" %> 