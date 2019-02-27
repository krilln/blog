<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<%@ include file="../include/header.jsp" %>
	
	<section class="content">
	<div class="row">
		<div class="col-sm-12">
		<div class="box">
			<div class="box-header with-border">
					<h3 class="box-title">블로그 목록</h3> 
				</div>
				<div class="box-body">
					<select name="searchType">
						<option value="n">---------------------------------</option>   
						<%-- <option value="tc" ${cri.searchType == 'tc' ? 'selected' : ''}>글</option> --%>
						<option value="b" ${cri.searchType == 'b' ? 'selected' : ''}>블로그명</option>
						<option value="nu" ${cri.searchType == 'nu' ? 'selected' : ''}>닉네임·아이디</option>
					</select>
					<input type="text" name="keyword" id="keyWordInput" value="${cri.keyword }">
					<button id="btnSearch">Search</button>
					<button id="btnNewBoard">New Board</button>
				</div>
			</div>
			<div class="box">
				<div class="box-body">
					<!-- table -->
					<table class="table">
						    <thead>
						      <tr> 
						      	<th>블로그 번호</th>
						        <th>블로그명</th>
						        <th>자기소개</th>
						        <th>닉네임(아이디)</th> 
						      </tr>
						    </thead>
						    <tbody>
						    	<c:forEach var="blog" items="${list }">  
						    	<tr>
						    		<td>${blog.blogNo }</td>
						    		<td><a href="#">${blog.blogName }</a></td>
						    		<td>${blog.introduction }</td>
						    		<td>${blog.nickname}(${blog.bUserId })</td>  
						    	</tr>	
						    	</c:forEach>
						    </tbody>
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pageMaker.prev }">
								<li><a href="${pageContext.request.contextPath }/blogHome/list?page=${pageMaker.startPage-1}&searchType=${cri.searchType}&keyword=${cri.keyword}">&laquo;</a></li>
							</c:if> 
							<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
								<li ${pageMaker.cri.page == idx ? 'class="active"' : "" } ><a href="${pageContext.request.contextPath }/blogHome/list?page=${idx}&searchType=${cri.searchType}&keyword=${cri.keyword}">${ idx}</a></li>
							</c:forEach>
							<c:if test="${pageMaker.next }">
								<li><a href="${pageContext.request.contextPath }/blogHome/list?page=${pageMaker.endPage+1}&searchType=${cri.searchType}&keyword=${cri.keyword}">&raquo;</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</section>

<script>
	$(function() {
		$("#btnSearch").click(function() {
			var searchType = $("select[name='searchType']").val();
			var keyword = $("#keyWordInput").val();
			location.href = "${pageContext.request.contextPath }/blogHome/list?searchType="+searchType+"&keyword="+keyword;
		})
		/* $("#btnNewBoard").click(function() {
			location.href = "${pageContext.request.contextPath }/sboard/registerS";
		}) */
	})
</script>

	






















