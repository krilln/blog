<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 
<style>
	.item{
		width: 200px;
		text-align: center;
	}
	.item img{
		width: 150px;
		margin: 0 auto; 
		text-align: center;
	}
	#category_div ul li{
		list-style: none;
	}
	#category_div ul li a{
		text-decoration: none;
		color: black;
	}
	#loginId, #blogId{
		display: none;
	}
	#sType{
		display: none;
	}
	#btnSearch{
		background-color: white;
		width: 45px;
	}
	.col-sm-2{
		margin: 0 auto;
		text-align: center;
	}
	.col-sm-2 a{
		text-decoration: none;
	}
	#manage{
		color: white;
		font-size: 14px;
		background-color: gray;
	}
	.boardImg img{
		width: 80%; 
	}
	.s_profile{
		float: left;
	}
	.s_profile img{
		border-radius: 100%;
		width: 20%;
	}
	#readTitle{
		font-size: 2em;
		font-weight: bold;
	}
	#readBoard{
		
	}
	.s_profile{
		width:20%;
		float: left;
	}
	.boardImg{
		width: 90%;
		margin: 0 auto;
		text-align: center;
	}
	.read_s_nick{
		font-size: 1.2em;
		font-weight: bold;
	}
	#readContent{
		padding-top: 50px;
		padding-bottom: 50px;
	}
	.read_s_profile{
		
	}
	.s_pro_img{
		width: 4%;
		border-radius: 100px;
	}
	#s_cate{
		font-weight: bold;
		color: gray;
	}
	#boardFooter{
		margin-top:5%;
		margin-bottom: 5%;
	}
	.text-center{
		/* border-bottom: 1px solid black; */
	}
	.cate_no{
		display: none;
	}
	.row{
		width:100%;
		padding: 10px;
	}
	.col-sm-2{
		border: 3px solid #D5D5D5;
		padding-bottom: 10px;
		padding-left: 3px;
		padding-right: 3px;
	}
	#category_div ul{
		padding-left: 0;
	}
	#keyWordInput{
		width: 150px;
		float: left;
	}
	#search_div{
		float: left;
	}
	#bo_title{
		width: 87%;
	}
	#btn_open_list{
		text-decoration: none;
		color: black;
	}
	#list_div{
		width: 99.5%;
		float: left;
		height: 40px;
		line-height: 40px;
	}
	#cate_name{
		width: 99.5%;
		float: left;
		
	}
	#cate_name a{
		float: right;
	}
	.search_box{
		display:none;
		border: 1px solid #D5D5D5;
		border-radius: 5px;
		margin-bottom: 20px;
	}
	#readTitle{
		margin-bottom: 20px;
	}
	.read_s_profile{
		border-bottom: 1px solid #D5D5D5;
		margin-bottom: 30px;
	}
	#btn_close_list{
		display:none;
		text-decoration: none;
		color: black;
	}
	.read_reply{
		width: 100%;
		margin:0 auto;
	}
	 .read_reply textarea{
		margin:0 auto;
	}
	#category_div{
		border: 1px solid #D5D5D5;
		border-radius: 5px;
		margin-bottom: 10px;
		padding-top: 10px;
	}
	#category_div li{
		text-align: left;
		padding-left: 20px;
	}
	#ni{
		font-weight: bold;
	}
	
</style> 
<section class="content">
<div class="row">
  <div class="col-sm-2">
  	<div>
	<span id="loginId">${login.userId }</span>
	<span id="blogId">${bUserId }</span>  
	<div class="item">
			<c:forEach var="file" items="${user_info.profileImage }">
                  	
                  		<img src="displayFile?filename=${fn:substring(file, 0, 9) += fn:substring(file,11,-1) }">
                  	
            </c:forEach>
                  </div>
     <p><span id="ni">${user_info.nickname }</span><br>(${user_info.userId })</p>
     <p>${blog_info.introduction }</p>
                  
	<p><a href="${pageContext.request.contextPath }/board/boardRegister?bUserId=${bUserId }" id='wri'>글쓰기</a> <a href="${pageContext.request.contextPath }/blogHome/blogModify?bUserId=${bUserId }" id="manage">관리</a></p>
	</div>
	<div id="category_div">
		<p><span style="font-weight: bold;">카테고리</span>   <a href="${pageContext.request.contextPath }/category/categoryRegister?bUserId=${bUserId }" id="ed">edit</a></p>
		<ul>
			<c:forEach var="cateList" items="${cate_list}">
				<li class="cate_li"><a href="#">- ${cateList.category}</a><span class="cate_no">${cateList.categoryNo}</span></li> 
			</c:forEach>
		</ul>
	</div>
	<div class="box-body" id="search_div">
					<select name="searchType" id="sType">  
						<option value="tc" ${cri.searchType == 'tc' ? 'selected' : ''}>Title or Content</option>
					</select>
					<input type="text" name="keyword" id="keyWordInput" >
					<button id="btnSearch">검색</button>
				</div>
  </div>
  <div class="col-sm-10">
  	<div id="list_div">
  		<div id="cate_name">
			<span id="s_cate">${read_bvo.category }</span> ${total }개의 글 <a href="#" id="btn_open_list">목록열기</a><a href="#" id="btn_close_list">목록닫기</a>
		</div>
			
 	</div>
  	<div class="box search_box">
				<div class="box-body">
					<!-- table -->
					<table class="table" id="boardList">
						    <thead>
						      <tr>
						        <th style="white:10px; display:none;">BNO</th>
						       <!--  <th>CATEGORY</th> -->
						        <th id="bo_title" style="font-weight: bold;">글 제목</th>
						        <!-- <th>WRITER</th> -->
						        <th id="bo_date">작성일</th>
						        <!-- <th style="white:40px;">VIEWCNT</th>   -->
						      </tr>
						    </thead>
						    <tbody>
						    	<c:forEach var="bo" items="${list }">  
						    	<tr>
						    		<td style="display:none;">${bo.bno }</td>
						    		<%-- <td>${bo.categoryNo }</td> --%>
						    		<td><a href="${pageContext.request.contextPath}/blogPage/blog?bno=${bo.bno }&page=${pageMaker.cri.page}&keyword=${cri.keyword}&searchType=${cri.searchType}&bUserId=${bUserId }&perPageNum=5">${bo.title }
						    			<strong>[${bo.replyCnt}]</strong>
						    		</a></td>
						    		<%-- <td>${bo.userId }</td>   --%>
						    		<td>
						    		<fmt:formatDate value='${bo.regdate }' pattern='yyyy-MM-dd HH:mm' type='date' dateStyle='short'/>
						    		</td>
						    		<%-- <td><span class="badge bg-red">${bo.viewCnt }</span></td> --%>
						    	</tr>	
						    	</c:forEach>
						    </tbody>
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pageMaker.prev }">
								<li><a href="${pageContext.request.contextPath }/blogPage/blog?bUserId=${bUserId }&bno=${bno }&page=${pageMaker.startPage-1}&searchType=${cri.searchType}&keyword=${cri.keyword}&perPageNum=5">&laquo;</a></li>
							</c:if> 
							<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
								<li ${pageMaker.cri.page == idx ? 'class="active"' : "" } ><a href="${pageContext.request.contextPath }/blogPage/blog?bUserId=${bUserId }&bno=${bno }&page=${idx}&searchType=${cri.searchType}&keyword=${cri.keyword}&perPageNum=5">${ idx}</a></li>
							</c:forEach>
							<c:if test="${pageMaker.next }">
								<li><a href="${pageContext.request.contextPath }/blogPage/blog?bUserId=${bUserId }&bno=${bno }&page=${pageMaker.endPage+1}&searchType=${cri.searchType}&keyword=${cri.keyword}&perPageNum=5">&raquo;</a></li>
							</c:if>
						</ul>
					</div>
					
				</div>
			</div>
  	<div id="readBoard">
  				<form id="f1" action="" method="post">
                  <input type="hidden" name="bno" value="${read_bvo.bno }">
                  <input type="hidden" name="page" value="${cri.page }">
                  <input type="hidden" name="searchType" value="${cri.searchType}">
                  <input type="hidden" name="keyword" value="${cri.keyword}">
               </form>
  		<div id="readTitle">${read_bvo.title }</div>
	  		<div class="read_s_profile">
		  		
		  		<%-- <div class="s_profile">
		  		<c:forEach var="file" items="${user_info.profileImage }">
		                  		<img src="displayFile?filename=${file }">
		       </c:forEach>
		       
		       </div> --%>
		       <img class="s_pro_img" src="displayFile?filename=${user_info.profileImage }">       
		      	 <a class="read_s_nick">${user_info.nickname }</a>
		       	<span><fmt:formatDate value='${read_bvo.regdate }' pattern='yyyy-MM-dd HH:mm' type='date' dateStyle='short'/></span>
		       	
		       	<a href="#" class="btnModify">수정</a>
		       	<a href="#" class="btnRemove">삭제</a>
	          </div>
              
  		<div id="readImg">
  			<div id="readContent">
  				${read_bvo.content }
  			</div>
	  		<div class="boardImg">
	  		<c:forEach var="file" items="${read_bvo.files }">
	                  	
	                  		<img src="displayFile?filename=${fn:substring(file, 0, 12) += fn:substring(file,14,-1) }">
	                  	
	                  	
	                  </c:forEach>
	        </div>
	        <div id="boardFooter">
	        	<div>댓글${read_bvo.replyCnt}</div>
	        </div>
	        <div class="read_reply">
	        	
	         <ul class="timeline">
	           <%--  <li class="time-label" id="repliesDiv">
	               <span class="bg-green" id="Rlist">댓글[${read_bvo.replyCnt}]</span>
	            </li> --%>
	            
	            
	         </ul>
	         <div class="text-center">
	            <ul id="pagination" class="pagination pagination-sm no-margin">
	            </ul>
	         </div>
	         <c:if test="${login != null }">
	         <div class="box box-success">
		            <div class="box-header">
		               <h3 class="box-title">댓글</h3>
		            </div>
		            <div class="box-body ">
		            	<input type="hidden" id="newReplybUserId" value="${bUserId }">
		               <input type="hidden" id="newReplyWriter" value="${login.userId }">
		               <!-- <input type="text" class="form-control" placeholder="Reply Text" id="newReplyText"> -->
		               <textarea rows="5" cols="100" placeholder="댓글을 입력해주세요." id="newReplyText" style="resize: none;"></textarea>
		               <p><input type="radio" name="open" class="newReplyOpen" value="false" checked="checked">공개
		                <input type="radio" name="open" class="newReplyOpen" value="true">비공개</p>
		            </div>
		            <div class="box-footer">
		               <button class="btn btn-primary" id="btnReplyAdd">댓글 작성</button>
		            </div>
		         </div>
		         </c:if>
		         <c:if test="${login == null }">
		         	<a href="#" class="myBtn"><textarea rows="5" cols="100" placeholder="댓글을 작성 하시려면 [로그인]을 해주세요." id="NoReplyText" style="resize: none;" disabled="disabled"></textarea></a>
		         </c:if>
	         
	        </div>
	        
	        <!-- 댓글 수정 모달 시작 -->
	        <div id="modifyModal" class="modal modal-primary fade" role="dialog">
		      <div class="modal-dialog">
		         <div class="modal-content">
		            <div class="modal-header">
		               <button type="button" class="close" data-dismiss="modal">&times;</button>
		            
		            </div>
		            <div class="modal-body">
		               <p><input type="text" id="replytext" class="form-control"></p><!--내용 들어감  -->
		            </div>
		            <div class="modal-footer">
		               <button type="button" class="btn btn-info" id="btnReplyMod"  data-rno="" >Modify</button>
		               <button type="button" class="btn btn-default" data-dismiss=modal>Close</button>
		            </div>
		         </div>
		      </div>
		   </div>
		    <!-- 댓글 수정 모달 끝 -->
		    
        </div>
        </div>
  </div>
</div>
</section>
<script>
	$(function() {
		if($("#loginId").text() == "" || $("#loginId").text() != $("#blogId").text()){
			$("#wri").css("display","none");
			$("#ed").css("display","none");
			$("#manage").css("display","none");
			$(".btnModify").css("display","none");
			$(".btnRemove").css("display","none");
		}
		if($("#loginId").text() == $("#blogId").text()){
			$("#wri").css("display","inline");
			$("#ed").css("display","inline");
			$("#manage").css("display","inline");
			$(".btnModify").css("display","inline");
			$(".btnRemove").css("display","inline");
		}
		if($("#loginId").text() != $(".timeline-header").text()){
			$(".timeline-footer").css("display","none");
		}
		if($("#loginId").text() == $(".timeline-header").text()){
			$(".timeline-footer").css("display","inline");
		}
		
		$("#btn_open_list").click(function() {
			$(".search_box").show();
			$("#btn_open_list").hide();
			$("#btn_close_list").show();
			
		})
		$("#btn_close_list").click(function() {
			$(".search_box").hide();
			$("#btn_open_list").show();
			$("#btn_close_list").hide();
		})
		
		$("#btnSearch").click(function() {
			var searchType = $("select[name='searchType']").val();
			var keyword = $("#keyWordInput").val();
			var bUserId = $("#blogId").text();
			location.href = "${pageContext.request.contextPath }/blogPage/blog?bUserId="+bUserId+"&searchType="+searchType+"&keyword="+keyword+"&perPageNum=5";
			$("#keyWordInput").text().empty();
		})
		$(".cate_li").click(function() {
			var keyWordInput_ca = $(this).children("span").eq(0).text();
			var searchType_c = 'ca';
			var keyword = $(this).children("span").eq(0).text();/* $("#keyWordInput").val(keyWordInput_ca); */
			var bUserId = $("#blogId").text();
			location.href = "${pageContext.request.contextPath }/blogPage/blog?bUserId="+bUserId+"&searchType="+searchType_c+"&keyword="+keyword+"&perPageNum=5";
			$("#keyWordInput").text().empty();
		})
		
		$(".btnRemove").click(function() {
         //#f1(form)를 submit 보냄
         location.href = "${pageContext.request.contextPath}/blogPage/blog?bUserId=${bUserId}&page=${cri.page}&searchType=${cri.searchType}&keyword=${cri.keyword}";
         $("#f1").attr("method", "post");
         $("#f1").attr("action", "/blog/board/removeBoard");
         $("#f1").submit();

      })
	})
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script>
	$(function() {
		$(".item").each(function(i, obj) {
			var img = new Image();
			img.onload = function() {
				$(obj).css("width", "40%");
			}
			img.src = $(obj).find("img").attr("src");
		})
		$(".boardImg").each(function(i, obj) {
			var img = new Image();
			img.onload = function() {
				$(obj).css("width", "80%");
			}
			img.src = $(obj).find("img").attr("src");
		})
		/* $(".s_profile").each(function(i, obj) {
			var img = new Image();
			img.onload = function() {
				/* $(obj).css("width", "90%"); 
			}
			img.src = $(obj).find("img").attr("src");
		})*/
	})
</script>
<script type="text/x-handlebars-template" id="template1">
{{#each.}}
<li class="replyLi" data-rno="{{rno}}">
<i class="fa fa-comments bg-blue"></i>
<div class="timeline-item">
   <p class="timeline-header">{{replyWriter}}</p>
   <div class="timeline-body" data-replytext={{replyContent}}>
      {{replyContent}}
   </div>
	<span class="item">
      <i class="fa fa-clock-o"></i>{{tempDate replyRegdate}}
   </span>
	<div class="timeline-body2" data-replyOpen={{replyOpen}}>
   </div>
   <div class="timeline-footer">
      <a class="btn btn-primary btn-xs btnModify" data-toggle="modal" data-target="#modifyModal"  data-rno="{{rno}}" data-text="{{replyContent}}">Modify</a>
      <a class="btn btn-danger btn-xs btnDelete" data-rno={{rno}}>Delete</a>
   </div>
</div>
</li>
{{/each}}
</script>
<script>
   Handlebars.registerHelper("tempDate",function(value){
      var date = new Date(value);
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var day = date.getDate();
      return year + "년 " + month + "월 " + day + "일 ";
   })
   

var bno = ${read_bvo.bno };
function getPageList(page) {
   
   $.ajax({
      url:"${pageContext.request.contextPath}/replies/"+bno+"/"+page,
      type:"get",
      dataType:"json",
      success:function(json){
         console.log(json);
      $(".replyLi").remove();
      
      var source = $("#template1").html();
      var template = Handlebars.compile(source);
      var result = template(json.list);
      $(".timeline").append(result);
      
      $("#pagination").empty();
      for (var i =json.pageMaker.startPage; i <= json.pageMaker.endPage; i++) {
         var liTag = $("<li>");
         var aTag = $("<a>").append(i).attr("href","#");
         liTag.append(aTag);
         
         if(i == json.pageMaker.cri.page){
            liTag.addClass("active");
         }
         $("#pagination").append(liTag);
   
      
      }
      
      }
   })
}

$(function() {
   getPageList(1);
   
   
   $("#btnReplyAdd").click(function() {
      //bno, replyer, replytext
   	  var userId = $("#newReplybUserId").val();
      var replyWriter = $("#newReplyWriter").val();
      var replyContent = $("#newReplyText").val();
      var replyOpen = $(".newReplyOpen").val();
      var jsonBody = {bno:bno, userId:userId, replyWriter:replyWriter, replyContent:replyContent, replyOpen:replyOpen }
      
      //@RestBody, header, JSON.stringify
      $.ajax({
         url:"${pageContext.request.contextPath}/replies/",
         type: "post",
         headers:{
            "Content-Type":"application/json",
            "X-HTTP-Method-Override":"POST"
            },
         data: JSON.stringify(jsonBody), //{bno:bno, replyer:replyer, replytext:replytext }
         dataType: "text",
         success:function(json){
            console.log(json); 
            $().empty();
            if(json=="success"){
               alert("등록하였습니다.");
               getPageList(1);
               $("#newReplyWriter").val("");
               $("#newReplyText").val("");
            }
           
         }
      })
   })
$(document).on("click", ".btnModify", function() {
         
         var rno = $(this).attr("data-rno");
         
         var text = $(this).attr("data-text");
         
         $("#replytext").attr("data-text",rno);
         $("#replytext").val(text)
         
         
      })
      
      $(document).on("click", "#btnReplyMod", function() {
         var replyContent = $("#replytext").val();
         var rno =  $("#replytext").attr("data-text");
         
         var jsonBody = {replyContent:replyContent};
         
         $.ajax({
            url:"${pageContext.request.contextPath}/replies/"+rno,
            type:"put",
            headers:{
               "Content-Type":"application/json",
               "X-HTTP-Method-Override":"PUT"      
            },
            data:JSON.stringify(jsonBody),
            dataType:"text",
            success: function (json) {
               console.log(json);
               if (json == "success") {
                  alert(rno+"가 수정되었습니다.")
               }
               $("#modifyModal").modal("hide");
               getPageList(1); 
            }
         })
         
      })
      $(document).on("click", ".btnDelete", function() {
         var rno = $(this).attr("data-rno");
      
         var jsonBody = {rno:rno}
         
         $.ajax({
            url:"${pageContext.request.contextPath}/replies/"+rno,
            type: "delete",
            dataType: "text",
            success:function(json){
               console.log(json);
               if(json=="success"){
                  alert(rno+"가 삭제되었습니다.");
               }
               getPageList(1);
            }
         })
         
      })
         $(document).on("click", ".pagination a", function(e) {
         e.preventDefault();
         var num = $(this).text();
         getPageList(num);
      })
   
})

</script>

<%@ include file="../include/footer.jsp" %> 