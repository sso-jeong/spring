<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/include/HEADER.jsp" %>
<body>
<%@ include file = "/WEB-INF/views/include/MENU.jsp" %>
<h2>회원로그인</h2>
<span id="checkLogin"></span>
<form id="frm" method="post">
	아이디 : <input placeholder="아이디입력" type="text" name="memID" id="memID" required maxlength="15" autofocus tabindex="1" />
	<br />	
	비밀번호 : <input type="password" name="memPwd" id="memPwd" required maxlength="12" tabindex="2" /><br />
	<button type="button" id="btn">로그인</button>
</form>
</body>
<script>
	$(function() {
		//data : $("#frm").serialize(),
		$("#btn").click(function() {
			
			$.ajax({
				url		: "${pageContext.request.contextPath}/login",
				type	: "POST",
				data 	: $("#frm").serialize(),
				success	: function(resData) {
					if( resData == "failure" ) {
						$("#checkLogin").html("등록된 사용자가 아닙니다.");

					}else{
						alert("로그인 되었습니다.");
						window.location.href = "${pageContext.request.contextPath}";
					}
				},
				error	: function() {
					alert("시스템 오류");
				}
			});
		});
		
	});
</script>
</html>











