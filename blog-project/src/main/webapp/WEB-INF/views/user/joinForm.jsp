<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<br/><br/>
	<div class="container" id="wrapper">
	 <h2>회원가입</h2>
	 <br>
	<!-- <form action="/user/join" method="POST">  json으로 처리할거라서 해당방식 사용x-->
	<form>
		<div class="form-group">
			<label for="username">*아이디</label> 
			<input type="text" class="form-control" placeholder="아이디를 입력하세요." id="username">
		</div>
		<p id="valid_username"></p>
		
		<div class="form-group">
			<label for="password">*비밀번호</label> <input type="password"
				class="form-control" placeholder="비밀번호를 입력하세요." id="password">
		</div>
		<p id="valid_password"></p>
		
		<div class="form-group">
			<label for="nickname">*이름</label> 
			<input type="text" class="form-control" placeholder="이름을 입력하세요." id="nickname">
		</div>
		<p id="valid_nickname"></p>
		
		<div class="form-group">
			<label for="email">*이메일</label> <input type="email"
				class="form-control" placeholder="이메일을 입력하세요." id="email">
		</div>
		<p id="valid_email"></p>
		
	</form>
		<!-- button을 form밖으로 빼야 함 -->
		<button id="btn-save" class="btn btn-info">회원가입</button>
		<!-- id="btn-save" js에서 쓰임 -->
</div>
		
<script src="/js/user.js"></script>

	<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>


