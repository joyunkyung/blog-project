<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<br/><br/>
	<div class="container" id="wrapper">
	 <h2>회원 정보 수정</h2>
	 <br/>
	<!-- <form action="/user/join" method="POST">  json으로 처리할거라서 해당방식 사용x-->
	<form>
		<input type="hidden" id="id" value="${principal.user.id}"/> <!-- user.js에 hidden으로 넘겨줌 -->
		<div class="form-group">
			<label for="username">아이디</label> 
			<input type="text" value="${principal.user.username}" class="form-control"  id="username" readonly="readonly">
		</div>
	
		<div class="form-group">
			<label for="password">비밀번호</label>
			 <input type="password"  class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<div class="form-group">
			<label for="password">이름</label>
			 <input type="text" value="${principal.user.nickname}"   class="form-control" placeholder="Enter nickname" id="nickname">
		</div>
		
		<div class="form-group">
			<label for="email">이메일</label>
			 <input type="email" value="${principal.user.email}"	 class="form-control" placeholder="Enter email" id="email">
		</div>
		
	</form>
		<!-- button을 form밖으로 빼야 함 -->
		<button id="btn-update" class="btn btn-primary">회원정보수정</button>
		<!-- id="btn-update" js에서 쓰임 -->
</div>

<script src="/js/user.js"></script>

	<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>


