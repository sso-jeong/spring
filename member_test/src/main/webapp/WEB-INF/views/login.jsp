<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<form id ="frm" method="post">
		아이디 : <input type="text" name="userid" id="userid" /><br />
		비밀번호 : <input type="text" name="passwd" id="passwd" /><br />
		<button type="button" id="btn">로그인</button>
	</form>
</body>
<script>
	$(function() {
		$("#btn").click(function(){
			//alert("test");
			if( $("#userid").val() == '' ){
				alert("아이디를 입력하세요.");
				$("#userid").val().focus();
				return false;
			}

			if( $("#passwd").val() == '' ){
				alert("비밀번호를 입력하세요.");
				$("#passwd").val().focus();
				return false;
			}

			var formData = {
					userid : $("#userid").val(),
					passwd : $("#passwd").val()
			};

			/* $.ajax({
				url		: "${pageContext.request.contextPath}/member/sessionLogin",
				type	: "POST",
				data	: formData,
				success : function(data) {
					if( data != null ) {
						alert("로그인되었습니다.");
						window.location.href= "${pageContext.request.contextPath}";
					} else {
						alert("아이디/비밀번호를 확인하세요.");
					}
				},
				error	: function(){
					alert("시스템 오류");
				}
			}); */
			
			$.ajax({
				url		: "${pageContext.request.contextPath}/member/sessionLogin",
				type	: "POST",
				data	: formData,
				success : function(resData) {
					if( resData == "success" ) {
						alert("로그인되었습니다.");
						window.location.href= '${pageContext.request.contextPath}';
					} else {
						alert("아이디/비밀번호를 확인하세요.");
					}
				},
				error	: function(){
					alert("시스템 오류");
				}
			}); 
		});
	});
</script>
</html>