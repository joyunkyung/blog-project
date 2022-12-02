<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<br/><br/><br/>

	<div class="container" id="wrapper">
	  <h2>로그인</h2>
	<form action="/auth/loginProc" method="post">
		<div class="form-group">
			<label for="username">ID</label> 
			<input type="text" name="username" class="form-control" placeholder="Enter ID" id="username">
		</div>
		
		
		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password"  name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<span> 
		    <c:if test="${error}">
		        <p id="valid" class="alert alert-danger">${exception}</p>
		    </c:if>
		</span>

		<button id="btn-login" class="btn btn-primary">로그인</button> 
		<a class="btn btn-primary"  href="/auth/joinForm">회원가입</a>
	</form>
</div>

	<!-- 푸터 -->
<%@ include file="../layout/footer.jsp" %>


