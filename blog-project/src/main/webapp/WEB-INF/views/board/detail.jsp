<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>


<div id="wrapper">
<div class="container" >
	<hr/>
  <h2>글 상세보기</h2>
  <table class="table table-bordered">

    <tbody>
      <tr>
        <td class="text-white-50 bg-dark" >글번호</td>
        <td>${board.id}</td>
        <td class="text-white-50 bg-dark">조회수</td>
        <td>${board.count+1}</td>
      </tr>
      <tr>
        <td class="text-white-50 bg-dark">작성자</td>
        <td colspan="3">${board.user.username}</td>    
      </tr>
      <tr>
        <td class="text-white-50 bg-dark">작성일</td>
        <td colspan="3"><fmt:formatDate value="${board.createDate}" pattern="yyyy/MM/dd"/></td>
      </tr>
      <tr>
        <td class="text-white-50 bg-dark">제목</td>
        <td colspan="3">${board.title}</td>  
      </tr>
    </tbody>
  </table>
    <div class="card">
		    <div id="collapseOne" class="collapse show" data-parent="#accordion">
		      <div class="card-body">${board.content} </div>
		    </div>	
		  </div>
</div>
<br/>
 	<div class="container">
			  <button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	 			
	 			<c:if test="${board.user.id == principal.user.id}" > <!-- 글작성자한테만 수정,삭제 버튼 뜸 -->
	 				<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
	 				<button  id="btn-delete" class="btn btn-danger">삭제</button>
	 			</c:if>	
	</div>

<br/>
	<!-- 댓글 -->
	<div class="container">
			<div class="card">
				<form>
					<input type="hidden" id="userId" value="${principal.user.id}">
					<input type="hidden" id="boardId" value="${board.id}">
					<div  class="card-body">
						<textarea id="comment-content" class="form-control" row="1"></textarea>
					</div>
					<div  class="card-footer">
						<button type="button"  id="btn-comment-save" class="btn btn-primary">댓글 등록</button>
					</div>
				</form>
			</div>	
			<br/>
			<div class="card">
				<div class="card-header">댓글 리스트</div>
				<ul id="comment-box" class="list-group">
					<c:forEach var="comment" items="${board.comments}">
							<li id="comment-${comment.id}"  class="list-group-item d-flex justify-content-between">
								<div>${comment.content}</div>
								<div class="d-flex">
									<div class="font-italic">작성자:  ${comment.user.username} &nbsp;</div>
									<c:if test="${comment.user.id eq principal.user.id}">
										<button onClick="index.commentDelete(${board.id}, ${comment.id})" class="badge">삭제</button>
									</c:if>
								</div>
							</li>
					</c:forEach>
				  	
				</ul>
			</div>	
		</div>
	</div>
</div>	
<script src="/js/board.js"></script>
	<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>


