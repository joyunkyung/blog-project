let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.save();
			});
			$("#btn-update").on("click", ()=>{ 
				this.update();
			});
			
				
		},

		save: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					nickname: $("#nickname").val(),
					email: $("#email").val()
			};
			
			//console.log(data);
			
			// ajax호출시 default가 비동기 호출
			// ajax 통신을 이용해서 4개의 데이터를 json으로 변경하여 insert 요청!!
			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환
			$.ajax({ 
				type: "POST",
				url: "/auth/joinProc",  //UserApiController.java
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
				if(resp.status == 400) {
				alert("회원가입 입력 정보를 다시 확인해주십시오.")
				
				if(resp.data.hasOwnProperty('valid_username')){
					$('#valid_username').text(resp.data.valid_username);
					$('#valid_username').css('color', 'red');
				}
				else $('#valid_userId').text('');
				
				if(resp.data.hasOwnProperty('valid_password')){
					$('#valid_password').text(resp.data.valid_password);
					$('#valid_password').css('color', 'red');
				}
				else $('#valid_password').text('');
				
				if(resp.data.hasOwnProperty('valid_nickname')){
					$('#valid_nickname').text(resp.data.valid_nickname);
					$('#valid_nickname').css('color', 'red');
				}
				else $('#valid_username').text('');
				
				if(resp.data.hasOwnProperty('valid_email')){
					$('#valid_email').text(resp.data.valid_email);
					$('#valid_email').css('color', 'red');
				}
				else $('#valid_email').text('');
			}
			else {
				alert("회원가입이 완료되었습니다.");
				location.href = "/auth/loginForm";	
			}
		/*			if(resp.status == 500){
					alert("회원가입에 실패하였습니다.");
				}else{
					alert("회원가입이 완료되었습니다.");
					location.href = "/";
				}
			*/
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 

			
		},
		
		//회원정보수정
		update: function(){
			let data = {
					id: $("#id").val(), //user/updateForm.jsp에서 hidden으로 넘긴값을 받아옴
					username: $("#username").val(),
					password: $("#password").val(),
					nickname: $("#nickname").val(),
					email: $("#email").val()
			};
			
			$.ajax({ 
				type: "PUT",
				url: "/user",
				data: JSON.stringify(data), 
				contentType: "application/json; charset=utf-8",
				dataType: "json" 
			}).done(function(resp){
					alert("회원정보 수정이 완료되었습니다.");
				
					
					location.href = "/";

			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 

			
		}
}

index.init();
