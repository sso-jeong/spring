<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/include/HEADER.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
<%@ include file = "/WEB-INF/views/include/MENU.jsp" %>
<h2>회원로그인</h2>
	<span id="checkLogin"></span>
 	<form id="frm" method="post" action="${pageContext.request.contextPath}/login">
		아이디 : <input type="text" name="memID" id="memID" /><br />
		비밀번호 : <input type="text" name="memPwd" id="memPwd" /><br />
		<button type="button" id="btn">로그인</button>
	</form>

</body>
<script>
	$(function() {
	
		$("#btn").click(function() {
			if( $("#memID").val() == '' ){
				alert("아이디를 입력하세요.");
				$("#memID").val().focus();
				return false;
			}
	
			if( $("#memPwd").val() == '' ){
				alert("비밀번호를 입력하세요.");
				$("#memPwd").val().focus();
				return false;
			}
			
			var formData = {
					userid	: $("#memID").val(),
					passwd	: $("#memPwd").val()
			};
	
			$.ajax({
				url		: "${pageContext.request.contextPath}/member/sessionLogin",
				type	: "POST",
				data	: {
					userid	: $("#memID").val(),
					passwd	: $("#memPwd").val()
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