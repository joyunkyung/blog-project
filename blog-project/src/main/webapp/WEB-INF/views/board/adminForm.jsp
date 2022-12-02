<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<div class="container">
  <h2>게시판</h2>
  <a class="btn btn-primary float-right"  href="/board/saveForm">글쓰기</a>
  <br/>
  <br/>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
        <th>조회수</th>
      </tr>
    </thead>
    <c:forEach var="board" items="${boards.content}">
	    <tbody>
	      <tr>
	        <td>${board.id}</td>
	        <td><a href="/board/${board.id}" >${board.title}</a></td>
	        <td>${board.user.username}</td>
	        <td><fmt:formatDate value="${board.createDate}" pattern="yyyy/MM/dd"/></td>
	        <td>${board.count}</td>
	      </tr>
	    </tbody>
    </c:forEach>	
  </table>
  <br/>
	<br/>
	
		<ul class="pagination justify-content-center"> <!-- 가운데 정렬 -->
			  <c:choose>
			  	<c:when test="${boards.first}"> <!-- 처음 페이지 이면  Previous 비활성화-->
			  		<li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			  	</c:when>
			  	<c:otherwise> <!-- Previous 활성화-->
			  		<li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
			  	</c:otherwise>
			  </c:choose>
			  	<c:forEach var="i" begin="1" end="${boards.totalPages}">
           			 <li class="page-item"><a class="page-link" href="?page=${i-1}">${i}</a></li>
        		</c:forEach>
			    <c:choose>
			  	<c:when test="${boards.last}"> <!-- 마지막 페이지 이면  Next 비활성화-->
			  		<li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			  	</c:when>
			  	<c:otherwise><!-- Next 활성화-->
			  		<li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
			  	</c:otherwise>
			  </c:choose>
		</ul>
</div>

	
<br>

	<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>


