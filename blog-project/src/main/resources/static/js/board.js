let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.save();
			});
			$("#btn-delete").on("click", ()=>{ 
				this.deleteById();
			});	
			$("#btn-update").on("click", ()=>{ 
				this.update();
			});
			$("#btn-comment-save").on("click", ()=>{ 
				this.commentSave();
			});
		},

		//글쓰기
		save: function(){
			let data = {
					title: $("#title").val(), //val(): value
					content: $("#content").val(),
			};
			
			$.ajax({ 
				type: "POST",
				url: "/api/board",
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
					alert("글쓰기가 완료되었습니다.");
					
					location.href = "/board/listForm";

			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		
		
		//삭제하기
		deleteById: function(){
			let id = $("#id").text();
			
			$.ajax({ 
				type: "DELETE",
				url: "/api/board/"+id,
				dataType: "json"
			}).done(function(resp){
				alert("삭제가 완료되었습니다.");
				location.href = "/board/listForm";
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		
		//수정하기
		update: function(){
			let id =$("#id").val();
			
			let data = {
					title: $("#title").val(),
					content: $("#content").val(),
			};
			
			$.ajax({ 
				type: "PUT",
				url: "/api/board/"+id,
				data: JSON.stringify(data), 
				contentType: "application/json; charset=utf-8",
				dataType: "json" 
			}).done(function(resp){
					alert("수정이 완료되었습니다.");
					
					location.href = "/board/listForm";

			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		
		//댓글작성
		commentSave: function(){
			let data = {
					userId: $("#userId").val(),
					boardId: $("#boardId").val(),
					content: $("#comment-content").val(),
			};
			
			
			$.ajax({ 
				type: "POST",
				url: `/api/board/${data.boardId}/comment`, //url 뒷부분의 게시물번호를 동적으로 받기 위해 백틱(`)사용
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
					alert("댓글작성이 완료되었습니다.");
					
					location.href = `/board/${data.boardId}`;

			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		
		//댓글삭제
		commentDelete: function(boardId, commentId){
			
			$.ajax({ 
				type: "DELETE",
				url: `/api/board/${boardId}/comment/${commentId}`, //url 뒷부분의 게시물번호를 동적으로 받기 위해 백틱(`)사용
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
					alert("댓글 삭제 성공");
					
					location.href = `/board/${boardId}`;

			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		
}

index.init();
