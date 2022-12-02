<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<div class="container" id="wrapper">
	
 		<form>			
		   <div class="input-group mb-3">
			    <div class="input-group-prepend">
			      <span class="input-group-text">&nbsp;&nbsp;제목&nbsp;&nbsp;</span>
			    </div>
			    <input type="text" class="form-control" placeholder="제목을 입력하세요" id="title">
			</div>
			
			
			<div class="form-group">
			 
			  <textarea class="form-control summernote" rows="5" id="content" ></textarea>
			</div>
			
		</form>
		<!-- button을 form밖으로 빼야 함 -->
		<button id="btn-save" class="btn btn-primary float-right">글쓰기</button> 
		<!-- id="btn-save" js에서 쓰임 (json 처리)-->
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


