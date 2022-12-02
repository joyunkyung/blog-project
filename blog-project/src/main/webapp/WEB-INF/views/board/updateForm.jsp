<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<div class="container" id="wrapper">
	
 		<form>
 			<input type="hidden"  id="id" value="${board.id}"/><!-- hidden으로 id값을 받아야함 -->
			 <div class="input-group mb-3">
			    <div class="input-group-prepend">
			      <span class="input-group-text">&nbsp;&nbsp;제목&nbsp;&nbsp;</span>
			    </div>
			    <input type="text" class="form-control"  value="${board.title}"  id="title">
			</div>
			
			<div class="form-group">
			  <textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
			</div>
			
		</form>
		<!-- button을 form밖으로 빼야 함 -->
		<button id="btn-update" class="btn btn-primary float-right">수정</button> 
		<!-- id="btn-update" js에서 쓰임 (json 처리)-->
	</div>
<br>


<!-- 섬머노트  -->
 <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>


<script src="/js/board.js"></script>
	<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>


