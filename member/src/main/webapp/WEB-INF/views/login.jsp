<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/member/HEADER.jsp" %>

<body>
	<form id ="frm" method="post">
		아이디 : <input type="text" name="userid" id="userid" /><br />
		비밀번호 : <input type="text" name="passwd" id="passwd" /><br />
		<button type="button" id="btn">로그인</button>
	</form>
</body>
<script>
	$(function() {
	
		$("#btn").click(function() {
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
					userid	: $("#userid").val(),
					passwd	: $("#passwd").val()
			};
	
			$.ajax({
				url		: "${pageContext.request.contextPath}/member/sessionLogin",
				type	: "POST",
				data	: {
					userid	: $("#userid").val(),
					passwd	: $("#passwd").val()
				},
				success	: function(data) {
					alert("로그인 되었습니다.");	
					window.location.href = 	"${pageContext.request.contextPath}";
				},
				error	: function() {
					alert("시스템 오류입니다.")
				}
			});
	
		});
	});  
</script>
</html>